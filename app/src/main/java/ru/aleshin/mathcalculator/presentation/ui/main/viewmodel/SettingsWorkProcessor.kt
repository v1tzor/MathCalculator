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
package ru.aleshin.mathcalculator.presentation.ui.main.viewmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.core.utils.platform.screenmodel.common.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.common.WorkProcessor
import ru.aleshin.mathcalculator.domain.interactors.SettingsInteractor
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainAction
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainEffect
import ru.aleshin.mathcalculator.presentation.ui.mappers.mapToUi
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SettingsWorkProcessor : WorkProcessor<SettingsWorkCommand, MainEffect> {

    fun loadThemeSettings(): Flow<MainEffect>

    class Base @Inject constructor(
        private val settingsInteractor: SettingsInteractor,
    ) : SettingsWorkProcessor {

        override fun loadThemeSettings() = work(SettingsWorkCommand.LoadThemeSettings)

        override fun work(command: SettingsWorkCommand) = when (command) {
            SettingsWorkCommand.LoadThemeSettings -> loadThemeSettingsWork()
        }

        private fun loadThemeSettingsWork() = flow<MainEffect> {
            settingsInteractor.fetchThemeSettings().collect { settings ->
                when (settings) {
                    is Either.Right -> emit(
                        MainAction.ChangeThemeSettings(
                            language = settings.data.language.mapToUi(),
                            themeColors = settings.data.themeColors.mapToUi(),
                        ),
                    )
                    is Either.Left -> error(
                        RuntimeException("Error get Theme Settings"),
                    )
                }
            }
        }
    }
}

sealed class SettingsWorkCommand : WorkCommand {
    object LoadThemeSettings : SettingsWorkCommand()
}