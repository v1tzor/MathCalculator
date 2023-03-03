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
package ru.aleshin.features.calculator.impl.presentation.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.core.ui.theme.material.ThemeColorsUiType
import ru.aleshin.core.ui.theme.tokens.LanguageUiType
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorTheme
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorViewState
import ru.aleshin.features.calculator.impl.presentation.ui.views.CalculateFirstLine
import ru.aleshin.features.calculator.impl.presentation.ui.views.CalculateFourthLine
import ru.aleshin.features.calculator.impl.presentation.ui.views.CalculateSecondLine
import ru.aleshin.features.calculator.impl.presentation.ui.views.CalculateThirtyLine

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun CalculatorContent(
    modifier: Modifier = Modifier,
    state: CalculatorViewState,
    onNumberSelected: (String) -> Unit,
    onClearAction: () -> Unit,
    onClearLastAction: () -> Unit,
    onSumAction: () -> Unit,
    onDifferenceAction: () -> Unit,
    onResultAction: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        CalculatorTitle(text = state.currentValue)
        Spacer(modifier = Modifier.weight(1f))
        Divider(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Column(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CalculateFirstLine(
                onNumberClick = onNumberSelected,
                onRemoveAllButtonClick = onClearLastAction,
            )
            CalculateSecondLine(
                onNumberClick = onNumberSelected,
                onRemoveButtonClick = onClearAction,
            )
            CalculateThirtyLine(
                onNumberClick = onNumberSelected,
                onSumButtonClick = onSumAction,
            )
            CalculateFourthLine(
                onNumberClick = onNumberSelected,
                onResultButtonClick = onResultAction,
                onDifferenceButtonClick = onDifferenceAction,
            )
        }
    }
}

@Composable
internal fun CalculatorTitle(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .animateContentSize(),
        textAlign = TextAlign.Right,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        text = text,
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.displayMedium,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
internal fun SettingsTopAppBar_Light_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.LIGHT,
        language = LanguageUiType.RU,
    ) {
        CalculatorTheme {
            Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                CalculatorContent(
                    state = CalculatorViewState(),
                    onClearLastAction = {},
                    onClearAction = {},
                    onNumberSelected = {},
                    onDifferenceAction = {},
                    onSumAction = {},
                    onResultAction = {},
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
internal fun SettingsTopAppBar_Dark_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.DARK,
        language = LanguageUiType.RU,
    ) {
        CalculatorTheme {
            Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                CalculatorContent(
                    state = CalculatorViewState(),
                    onClearLastAction = {},
                    onClearAction = {},
                    onNumberSelected = {},
                    onDifferenceAction = {},
                    onSumAction = {},
                    onResultAction = {},
                )
            }
        }
    }
}