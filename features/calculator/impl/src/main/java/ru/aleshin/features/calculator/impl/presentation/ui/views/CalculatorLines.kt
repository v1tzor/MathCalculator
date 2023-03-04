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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorThemeRes

/**
 * @author Stanislav Aleshin on 02.03.2023.
 */
@Composable
internal fun CalculateFirstLine(
    onOperatorClick: (String) -> Unit,
    onClearAllClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = { onClearAllClick.invoke() },
            color = MaterialTheme.colorScheme.errorContainer,
            title = CalculatorThemeRes.strings.clearAllButtonTitle,
        )
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onOperatorClick,
            title = CalculatorThemeRes.strings.splitButtonTitle,
        )
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onOperatorClick,
            title = CalculatorThemeRes.strings.multiplyButtonTitle,
        )
    }
}

@Composable
internal fun CalculateSecondLine(
    onNumberClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.sevenButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.eightButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.nineButtonTitle,
        )
    }
}

@Composable
internal fun CalculateThirtyLine(
    onNumberClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.fourButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.fiveButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.sixButtonTitle,
        )
    }
}

@Composable
internal fun CalculateFourthLine(
    onNumberClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.oneButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.twoButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.threeButtonTitle,
        )
    }
}

@Composable
internal fun CalculateFifthLine(
    onNumberClick: (String) -> Unit,
    onOperatorClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = {},
            title = CalculatorThemeRes.strings.emptyButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.zeroButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onOperatorClick,
            title = CalculatorThemeRes.strings.dotButtonTitle,
        )
    }
}

@Composable
internal fun CalculateVerticalColumn(
    modifier: Modifier = Modifier,
    onOperatorClick: (String) -> Unit,
    onResultClick: () -> Unit,
    onClearLastClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(start = 8.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onClearLastClick.invoke() },
            title = CalculatorThemeRes.strings.clearLastButtonTitle,
        )
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onOperatorClick,
            title = CalculatorThemeRes.strings.sumButtonTitle,
        )
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onOperatorClick,
            title = CalculatorThemeRes.strings.differenceButtonTitle,
        )
        ActionResultButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onResultClick,
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun NumberButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    title: String,
) {
    Surface(
        modifier = modifier.requiredHeight(64.dp),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = MathCalculatorRes.elevations.levelOne,
        onClick = { onClick.invoke(title) },
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun ActionButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    color: Color = MaterialTheme.colorScheme.secondaryContainer,
    title: String,
) {
    Surface(
        modifier = modifier.requiredHeight(64.dp),
        shape = MaterialTheme.shapes.small,
        color = color,
        onClick = { onClick.invoke(title) },
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun ActionResultButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val title = CalculatorThemeRes.strings.resultButtonTitle
    Surface(
        modifier = modifier.requiredHeight(136.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.secondaryContainer,
        onClick = onClick,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}