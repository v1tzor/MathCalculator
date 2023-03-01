package ru.aleshin.core.ui.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MathCalculatorElevations(
    val levelOne: Dp,
    val levelTwo: Dp,
    val levelThree: Dp,
    val levelFour: Dp,
    val levelFive: Dp,
)

val baseMathCalculatorElevations = MathCalculatorElevations(
    levelOne = 1.dp,
    levelTwo = 3.dp,
    levelThree = 6.dp,
    levelFour = 8.dp,
    levelFive = 12.dp,
)

val LocalMathCalculatorElevations = staticCompositionLocalOf<MathCalculatorElevations> {
    error("Elevations is not provided")
}
