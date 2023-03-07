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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorViewState
import ru.aleshin.features.calculator.impl.presentation.ui.views.*
import ru.aleshin.features.calculator.impl.presentation.ui.views.CalculateFirstLine

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
        CalculatorTitle(calculateLine = state.currentValue, result = state.result)
        Spacer(modifier = Modifier.weight(1f))
        Divider(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Row(modifier = Modifier.padding(bottom = 32.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                CalculateFirstLine(onOperatorClick = onOperatorSelected, onClearAllClick = onClearAllButtonClick)
                CalculateSecondLine(onNumberClick = onNumberSelected)
                CalculateThirtyLine(onNumberClick = onNumberSelected)
                CalculateFourthLine(onNumberClick = onNumberSelected)
                CalculateFifthLine(onNumberClick = onNumberSelected, onOperatorClick = onOperatorSelected)
            }
            CalculateVerticalColumn(
                modifier = Modifier.width(100.dp),
                onOperatorClick = onOperatorSelected,
                onClearLastClick = onClearLastButtonClick,
                onResultClick = onResultButtonClick,
            )
        }
    }
}

@Composable
internal fun CalculatorTitle(calculateLine: String, result: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)) {
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