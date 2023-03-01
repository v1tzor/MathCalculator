package ru.aleshin.features.calculator.impl.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.core.ui.theme.material.ThemeColorsUiType
import ru.aleshin.core.ui.theme.tokens.LanguageUiType
import ru.aleshin.core.ui.views.TopAppBarButton
import ru.aleshin.core.ui.views.TopAppBarTitle
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorTheme
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorThemeRes

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun CalculatorTopAppBar(
    onSettingsButtonClick: () -> Unit,
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
            TopAppBarButton(
                imageVector = Icons.Default.Settings,
                imageDescription = CalculatorThemeRes.strings.settingsIconDesc,
                onButtonClick = onSettingsButtonClick,
            )
        },
    )
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun CalculatorTopAppBar_Light_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.LIGHT,
        language = LanguageUiType.RU,
    ) {
        CalculatorTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                content = { Box(modifier = Modifier.padding(it)) {} },
                topBar = {
                    CalculatorTopAppBar(
                        onSettingsButtonClick = {},
                    )
                },
            )
        }
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun CalculatorTopAppBar_Dark_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.DARK,
        language = LanguageUiType.RU,
    ) {
        CalculatorTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                content = { Box(modifier = Modifier.padding(it)) {} },
                topBar = {
                    CalculatorTopAppBar(
                        onSettingsButtonClick = {},
                    )
                },
            )
        }
    }
}