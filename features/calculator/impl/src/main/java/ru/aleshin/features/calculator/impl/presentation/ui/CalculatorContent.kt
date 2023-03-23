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

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorThemeRes
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorViewState
import ru.aleshin.features.calculator.impl.presentation.ui.views.*

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun CalculatorContent(
    modifier: Modifier = Modifier,
    state: CalculatorViewState,
    onNumberSelected: (String) -> Unit,
    onOperatorSelected: (String) -> Unit,
    onResultButtonClick: () -> Unit,
    onClearLastButtonClick: () -> Unit,
    onClearAllButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Box(modifier = Modifier.weight(0.3f), contentAlignment = Alignment.Center) {
            CalculatorTitle(
                calculateLine = state.currentValue,
                result = state.result,
            )
        }
        Divider(
            Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Row(
            modifier = Modifier.weight(0.7f).padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                ActionButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onClearAllButtonClick.invoke() },
                    color = MaterialTheme.colorScheme.errorContainer,
                    title = CalculatorThemeRes.strings.clearAllButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.sevenButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.fourButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.oneButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    title = CalculatorThemeRes.strings.emptyButtonTitle,
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                ActionButton(
                    modifier = Modifier.weight(1f),
                    onClick = onOperatorSelected,
                    title = CalculatorThemeRes.strings.splitButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.eightButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.fiveButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.twoButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.zeroButtonTitle,
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                ActionButton(
                    modifier = Modifier.weight(1f),
                    onClick = onOperatorSelected,
                    title = CalculatorThemeRes.strings.multiplyButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.nineButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.sixButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNumberSelected,
                    title = CalculatorThemeRes.strings.threeButtonTitle,
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    onClick = onOperatorSelected,
                    title = CalculatorThemeRes.strings.dotButtonTitle,
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Column(
                    modifier = Modifier.weight(0.6f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    ActionButton(
                        modifier = Modifier.weight(1f),
                        onClick = { onClearLastButtonClick.invoke() },
                        title = CalculatorThemeRes.strings.clearLastButtonTitle,
                    )
                    ActionButton(
                        modifier = Modifier.weight(1f),
                        onClick = onOperatorSelected,
                        title = CalculatorThemeRes.strings.sumButtonTitle,
                    )
                    ActionButton(
                        modifier = Modifier.weight(1f),
                        onClick = onOperatorSelected,
                        title = CalculatorThemeRes.strings.differenceButtonTitle,
                    )
                }
                ActionResultButton(
                    modifier = Modifier.weight(0.4f),
                    onClick = onResultButtonClick,
                )
            }
        }
    }
}

@Composable
internal fun CalculatorTitle(
    modifier: Modifier = Modifier,
    calculateLine: String,
    result: String,
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(state = scrollState, reverseScrolling = true),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right,
                maxLines = 1,
                text = calculateLine,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.displayMedium,
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = result,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.headlineMedium,
        )
    }
}

// @Preview(showBackground = true, showSystemUi = true)
// @Composable
// internal fun SettingsTopAppBar_Light_Preview() {
//    MathCalculatorTheme(
//        dynamicColor = false,
//        themeColorsType = ThemeColorsUiType.LIGHT,
//        language = LanguageUiType.RU,
//    ) {
//        CalculatorTheme {
//            Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
//                CalculatorContent(
//                    state = CalculatorViewState(),
//                    onNumberSelected = {},
//                    onOperatorSelected = {},
//                    onResultButtonClick = {},
//                    onClearLastButtonClick = {},
//                    onClearAllButtonClick = {},
//                )
//            }
//        }
//    }
// }
//
// @Preview(showBackground = true, showSystemUi = true)
// @Composable
// internal fun SettingsTopAppBar_Dark_Preview() {
//    MathCalculatorTheme(
//        dynamicColor = false,
//        themeColorsType = ThemeColorsUiType.DARK,
//        language = LanguageUiType.RU,
//    ) {
//        CalculatorTheme {
//            Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
//                CalculatorContent(
//                    state = CalculatorViewState(),
//                    onNumberSelected = {},
//                    onOperatorSelected = {},
//                    onResultButtonClick = {},
//                    onClearLastButtonClick = {},
//                    onClearAllButtonClick = {},
//                )
//            }
//        }
//    }
// }