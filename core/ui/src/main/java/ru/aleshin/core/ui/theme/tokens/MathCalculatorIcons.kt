package ru.aleshin.core.ui.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import ru.aleshin.core.ui.R

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MathCalculatorIcons(
    val back: Int,
)

val baseMathCalculatorIcons = MathCalculatorIcons(
    back = R.drawable.ic_back,
)

val LocalMathCalculatorIcons = staticCompositionLocalOf<MathCalculatorIcons> {
    error("Core Icons is not provided")
}
