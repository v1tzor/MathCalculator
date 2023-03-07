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
package ru.aleshin.features.settings.impl.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.platform.screen.rememberViewState
import ru.aleshin.features.settings.impl.presentation.theme.SettingsTheme
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsEvent
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsViewState
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.rememberSettingsScreenModel
import ru.aleshin.features.settings.impl.presentation.ui.views.SettingsTopAppBar
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class SettingsScreen @Inject constructor() : Screen {

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        val screenModel = rememberSettingsScreenModel()
        val state = rememberViewState(screenModel, SettingsViewState())

        SettingsTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                content = { paddingValues ->
                    SettingsContent(
                        modifier = Modifier.padding(paddingValues),
                        state = state,
                        onUpdateThemeSettings = { screenModel.dispatchEvent(SettingsEvent.ChangedThemeSettings(it)) },
                    )
                },
                topBar = {
                    SettingsTopAppBar(
                        onBackButtonClick = { screenModel.dispatchEvent(SettingsEvent.PressBackButton) },
                    )
                },
            )
        }
    }
}