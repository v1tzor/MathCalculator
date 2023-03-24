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
package ru.aleshin.features.settings.impl.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.core.ui.theme.material.ThemeColorsUiType
import ru.aleshin.core.ui.theme.tokens.LanguageUiType
import ru.aleshin.core.ui.views.*
import ru.aleshin.features.settings.impl.presentation.theme.SettingsTheme
import ru.aleshin.features.settings.impl.presentation.theme.SettingsThemeRes

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun SettingsTopAppBar(
    onBackButtonClick: () -> Unit,
) {
    TopAppBar(
        title = {
            TopAppBarTitle(
                text = SettingsThemeRes.strings.settingsTitle,
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            TopAppBarButton(
                imageVector = Icons.Default.ArrowBack,
                imageDescription = SettingsThemeRes.strings.backIconDesc,
                onButtonClick = onBackButtonClick,
            )
        },
        actions = {
            Spacer(modifier = Modifier.size(48.dp))
        },
    )
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SettingsTopAppBar_Light_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.LIGHT,
        language = LanguageUiType.RU,
    ) {
        SettingsTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                content = { Box(modifier = Modifier.padding(it)) {} },
                topBar = {
                    SettingsTopAppBar(
                        onBackButtonClick = {},
                    )
                },
            )
        }
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SettingsTopAppBar_Dark_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.DARK,
        language = LanguageUiType.RU,
    ) {
        SettingsTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                content = { Box(modifier = Modifier.padding(it)) {} },
                topBar = {
                    SettingsTopAppBar(
                        onBackButtonClick = {},
                    )
                },
            )
        }
    }
}