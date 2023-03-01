package ru.aleshin.features.calculator.impl.presentation.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import ru.aleshin.features.calculator.impl.R

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal data class CalculatorIcons(
    val settings: Int,
)

internal val baseCalculatorIcons = CalculatorIcons(
    settings = R.drawable.ic_settings,
)

internal val LocalCalculatorIcons = staticCompositionLocalOf<CalculatorIcons> {
    error("Settings Icons is not provided")
}
