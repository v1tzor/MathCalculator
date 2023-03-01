package ru.aleshin.core.ui.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MathCalculatorStrings(
    val appName: String,
)

val russianMathCalculatorString = MathCalculatorStrings(
    appName = "MathCalculator",
)

val englishMathCalculatorString = MathCalculatorStrings(
    appName = "MathCalculator",
)

val LocalMathCalculatorStrings = staticCompositionLocalOf<MathCalculatorStrings> {
    error("Core Strings is not provided")
}
