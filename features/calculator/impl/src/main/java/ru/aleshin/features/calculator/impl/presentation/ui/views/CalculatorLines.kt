package ru.aleshin.features.calculator.impl.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorThemeRes

/**
 * @author Stanislav Aleshin on 02.03.2023.
 */
@Composable
internal fun CalculateFirstLine(
    onNumberClick: (String) -> Unit,
    onRemoveButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
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
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onRemoveButtonClick,
            title = CalculatorThemeRes.strings.removeButtonTitle,
        )
    }
}

@Composable
internal fun CalculateSecondLine(
    onNumberClick: (String) -> Unit,
    onPlusButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
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
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onPlusButtonClick,
            title = CalculatorThemeRes.strings.plusButtonTitle,
        )
    }
}

@Composable
internal fun CalculateThirtyLine(
    onNumberClick: (String) -> Unit,
    onMinusButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
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
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onMinusButtonClick,
            title = CalculatorThemeRes.strings.minusButtonTitle,
        )
    }
}

@Composable
internal fun CalculateFourthLine(
    onNumberClick: (String) -> Unit,
    onResultButtonClick: () -> Unit,
    onRemoveAllButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = {},
            title = CalculatorThemeRes.strings.emptyButtonTitle,
        )
        NumberButton(
            modifier = Modifier.weight(1f),
            onClick = onNumberClick,
            title = CalculatorThemeRes.strings.twoButtonTitle,
        )
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onRemoveAllButtonClick,
            title = CalculatorThemeRes.strings.removeAllButtonTitle,
        )
        ActionButton(
            modifier = Modifier.weight(1f),
            onClick = onResultButtonClick,
            title = CalculatorThemeRes.strings.resultButtonTitle,
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
    onClick: () -> Unit,
    title: String,
) {
    Surface(
        modifier = modifier.requiredHeight(64.dp),
        shape = MaterialTheme.shapes.small,
        tonalElevation = MathCalculatorRes.elevations.levelThree,
        onClick = onClick,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}