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

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.features.settings.impl.presentation.theme.SettingsThemeRes
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsViewState
import ru.aleshin.features.settings.impl.presentation.ui.views.LanguageChooser
import ru.aleshin.features.settings.impl.presentation.ui.views.ThemeColorsChooser

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun SettingsContent(
    modifier: Modifier = Modifier,
    state: SettingsViewState,
    onUpdateThemeSettings: (ThemeSettings) -> Unit,
) {
    if (state.themeSettings != null) {
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = SettingsThemeRes.strings.mainSettingsTitle,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge,
                )
                ThemeColorsChooser(
                    modifier = Modifier.fillMaxWidth(),
                    currentThemeColors = state.themeSettings.themeColors,
                    onThemeColorUpdate = { colorsType ->
                        onUpdateThemeSettings.invoke(state.themeSettings.copy(themeColors = colorsType))
                    },
                )
                LanguageChooser(
                    language = state.themeSettings.language,
                    onLanguageChanged = { language ->
                        onUpdateThemeSettings.invoke(state.themeSettings.copy(language = language))
                    }
                )
            }
        }
    }
}

// @Preview(showSystemUi = true, showBackground = true)
// @Composable
// private fun SettingsContent_Preview() {
//    MathCalculatorTheme(
//        dynamicColor = false,
//        themeColorsType = ThemeColorsUiType.LIGHT,
//        language = LanguageUiType.RU,
//    ) {
//        SettingsTheme {
//            val state = SettingsViewState(
//                themeSettings = ThemeSettings(LanguageType.RU, ThemeColorsType.LIGHT),
//            )
//            SettingsContent(
//                state = state,
//                onUpdateThemeSettings = {},
//            )
//        }
//    }
// }