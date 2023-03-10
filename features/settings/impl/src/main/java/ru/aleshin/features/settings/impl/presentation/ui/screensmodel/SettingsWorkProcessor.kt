/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package ru.aleshin.features.settings.impl.presentation.ui.screensmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.core.utils.platform.screenmodel.common.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.common.WorkProcessor
import ru.aleshin.features.settings.impl.domain.interactors.SettingsInteractor
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsAction
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsWorkProcessor : WorkProcessor<SettingsWorkCommand, SettingsEffect> {

    fun loadAllSettings(): Flow<SettingsEffect>

    fun updateThemeSettings(settings: ThemeSettings): Flow<SettingsEffect>

    class Base @Inject constructor(
        private val settingsInteractor: SettingsInteractor,
    ) : SettingsWorkProcessor {

        override fun loadAllSettings() = work(
            command = SettingsWorkCommand.LoadAllSettings,
        )

        override fun updateThemeSettings(settings: ThemeSettings) = work(
            command = SettingsWorkCommand.UpdateThemeSettings(settings),
        )

        override fun work(command: SettingsWorkCommand) = when (command) {
            is SettingsWorkCommand.UpdateThemeSettings -> updateThemeSettingsWork(command.settings)
            is SettingsWorkCommand.LoadAllSettings -> loadAllSettingsWork()
        }

        private fun updateThemeSettingsWork(settings: ThemeSettings) = flow<SettingsEffect> {
            when (val either = settingsInteractor.updateThemeSettings(settings)) {
                is Either.Right -> emit(SettingsAction.ChangeThemeSettings(settings))
                is Either.Left -> emit(SettingsAction.ShowError(either.data))
            }
        }

        private fun loadAllSettingsWork() = flow<SettingsEffect> {
            when (val settings = settingsInteractor.fetchAllSettings()) {
                is Either.Right -> emit(SettingsAction.ChangeAllSettings(settings.data))
                is Either.Left -> emit(SettingsAction.ShowError(settings.data))
            }
        }
    }
}

internal sealed class SettingsWorkCommand : WorkCommand {
    object LoadAllSettings : SettingsWorkCommand()
    data class UpdateThemeSettings(val settings: ThemeSettings) : SettingsWorkCommand()
}