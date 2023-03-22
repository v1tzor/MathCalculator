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
package ru.aleshin.features.calculator.impl.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.views.TopAppBarAction
import ru.aleshin.core.ui.views.TopAppBarMoreActions
import ru.aleshin.core.ui.views.TopAppBarTitle
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorThemeRes

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun CalculatorTopAppBar(
    onSettingsButtonClick: () -> Unit,
    onHistoryButtonClick: () -> Unit,
) {
    TopAppBar(
        title = {
            TopAppBarTitle(
                text = CalculatorThemeRes.strings.calculatorTitle,
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            Spacer(modifier = Modifier.size(48.dp))
        },
        actions = {
            TopAppBarMoreActions(
                items = CalculatorAppBarMoreActions.values(),
                onItemClick = { item ->
                    when (item) {
                        CalculatorAppBarMoreActions.HISTORY -> onHistoryButtonClick()
                        CalculatorAppBarMoreActions.SETTINGS -> onSettingsButtonClick()
                    }
                },
                moreIconDescription = CalculatorThemeRes.strings.moreIconDesc,
            )
        },
    )
}

internal enum class CalculatorAppBarMoreActions : TopAppBarAction {
    HISTORY {
        override val icon: Int @Composable get() = CalculatorThemeRes.icons.history
        override val title @Composable get() = CalculatorThemeRes.strings.historyIconDesc
        override val isAlwaysShow = false
    },
    SETTINGS {
        override val icon: Int @Composable get() = CalculatorThemeRes.icons.settings
        override val title @Composable get() = CalculatorThemeRes.strings.settingsIconDesc
        override val isAlwaysShow = false
    },
}

// @Preview
// @Composable
// @OptIn(ExperimentalMaterial3Api::class)
// internal fun CalculatorTopAppBar_Light_Preview() {
//    MathCalculatorTheme(
//        dynamicColor = false,
//        themeColorsType = ThemeColorsUiType.LIGHT,
//        language = LanguageUiType.RU,
//    ) {
//        CalculatorTheme {
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//                content = { Box(modifier = Modifier.padding(it)) {} },
//                topBar = {
//                    CalculatorTopAppBar(
//                        onSettingsButtonClick = {},
//                        onHistoryButtonClick = {},
//                    )
//                },
//            )
//        }
//    }
// }
//
// @Preview
// @Composable
// @OptIn(ExperimentalMaterial3Api::class)
// internal fun CalculatorTopAppBar_Dark_Preview() {
//    MathCalculatorTheme(
//        dynamicColor = false,
//        themeColorsType = ThemeColorsUiType.DARK,
//        language = LanguageUiType.RU,
//    ) {
//        CalculatorTheme {
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//                content = { Box(modifier = Modifier.padding(it)) {} },
//                topBar = {
//                    CalculatorTopAppBar(
//                        onSettingsButtonClick = {},
//                        onHistoryButtonClick = {},
//                    )
//                },
//            )
//        }
//    }
// }