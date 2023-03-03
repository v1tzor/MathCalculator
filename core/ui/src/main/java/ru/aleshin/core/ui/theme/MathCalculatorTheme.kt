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
package ru.aleshin.core.ui.theme

import androidx.compose.material3.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.aleshin.core.ui.theme.material.*
import ru.aleshin.core.ui.theme.tokens.*

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
fun MathCalculatorTheme(
    dynamicColor: Boolean = true,
    themeColorsType: ThemeColorsUiType = ThemeColorsUiType.DEFUALT,
    language: LanguageUiType = LanguageUiType.DEFUALT,
    content: @Composable () -> Unit,
) {
    val appLanguage = when (language) {
        LanguageUiType.DEFUALT -> MathCalculatorLocale()
        LanguageUiType.EN -> MathCalculatorLanguage.EN
        LanguageUiType.RU -> MathCalculatorLanguage.RU
    }
    val appStrings = when (appLanguage) {
        MathCalculatorLanguage.RU -> russianMathCalculatorString
        MathCalculatorLanguage.EN -> englishMathCalculatorString
    }
    val appElevations = baseMathCalculatorElevations
    val appIcons = baseMathCalculatorIcons

    MaterialTheme(
        colorScheme = themeColorsType.toColorScheme(dynamicColor),
        shapes = baseShapes,
        typography = baseTypography,
    ) {
        CompositionLocalProvider(
            LocalMathCalculatorLanguage provides appLanguage,
            LocalMathCalculatorElevations provides appElevations,
            LocalMathCalculatorStrings provides appStrings,
            LocalMathCalculatorIcons provides appIcons,
            content = content,
        )
        MathCalculatorSystemUi(
            navigationBarColor = colorScheme.surface,
            statusBarColor = colorScheme.surface,
            isDarkIcons = themeColorsType.isDarkTheme(),
        )
    }
}

@Composable
fun MathCalculatorSystemUi(navigationBarColor: Color, statusBarColor: Color, isDarkIcons: Boolean) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setNavigationBarColor(color = navigationBarColor, darkIcons = !isDarkIcons)
        systemUiController.setStatusBarColor(color = statusBarColor, darkIcons = !isDarkIcons)
    }
}
