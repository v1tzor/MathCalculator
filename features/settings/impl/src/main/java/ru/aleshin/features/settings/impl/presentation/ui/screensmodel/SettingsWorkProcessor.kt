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

import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.core.utils.platform.screenmodel.work.ActionResult
import ru.aleshin.core.utils.platform.screenmodel.work.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.work.WorkProcessor
import ru.aleshin.core.utils.platform.screenmodel.work.WorkResult
import ru.aleshin.features.settings.impl.domain.interactors.SettingsInteractor
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsAction
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsWorkProcessor : WorkProcessor<SettingsWorkCommand, SettingsAction, SettingsEffect> {

    suspend fun loadAllSettings(): WorkResult<SettingsAction, SettingsEffect>

    suspend fun updateThemeSettings(settings: ThemeSettings): WorkResult<SettingsAction, SettingsEffect>

    class Base @Inject constructor(
        private val settingsInteractor: SettingsInteractor,
    ) : SettingsWorkProcessor {

        override suspend fun loadAllSettings() = work(
            command = SettingsWorkCommand.LoadAllSettings,
        )

        override suspend fun updateThemeSettings(settings: ThemeSettings) = work(
            command = SettingsWorkCommand.UpdateThemeSettings(settings),
        )

        override suspend fun work(command: SettingsWorkCommand) = when (command) {
            is SettingsWorkCommand.UpdateThemeSettings -> updateThemeSettingsWork(command.settings)
            is SettingsWorkCommand.LoadAllSettings -> loadAllSettingsWork()
        }

        private suspend fun updateThemeSettingsWork(
            settings: ThemeSettings,
        ) = when (val either = settingsInteractor.updateThemeSettings(settings)) {
            is Either.Right -> ActionResult(SettingsAction.ChangeThemeSettings(settings))
            is Either.Left -> ActionResult(SettingsAction.ShowError(either.data))
        }

        private suspend fun loadAllSettingsWork() = when (
            val settings = settingsInteractor.fetchAllSettings()
        ) {
            is Either.Right -> ActionResult(SettingsAction.ChangeAllSettings(settings.data))
            is Either.Left -> ActionResult(SettingsAction.ShowError(settings.data))
        }
    }
}

internal sealed class SettingsWorkCommand : WorkCommand {
    object LoadAllSettings : SettingsWorkCommand()
    data class UpdateThemeSettings(val settings: ThemeSettings) : SettingsWorkCommand()
}