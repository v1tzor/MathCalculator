package ru.aleshin.core.ui.theme

import androidx.compose.runtime.Composable
import ru.aleshin.core.ui.theme.tokens.*

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
object MathCalculatorRes {

    val elevations: MathCalculatorElevations
        @Composable get() = LocalMathCalculatorElevations.current

    val language: MathCalculatorLanguage
        @Composable get() = LocalMathCalculatorLanguage.current

    val strings: MathCalculatorStrings
        @Composable get() = LocalMathCalculatorStrings.current

    val icons: MathCalculatorIcons
        @Composable get() = LocalMathCalculatorIcons.current
}
