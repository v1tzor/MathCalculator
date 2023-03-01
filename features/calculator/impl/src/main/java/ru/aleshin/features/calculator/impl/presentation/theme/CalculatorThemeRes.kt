package ru.aleshin.features.calculator.impl.presentation.theme

import androidx.compose.runtime.Composable
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.CalculatorIcons
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.CalculatorStrings
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.LocalCalculatorIcons
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.LocalCalculatorStrings

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal object CalculatorThemeRes {

    val strings: CalculatorStrings
        @Composable get() = LocalCalculatorStrings.current

    val icons: CalculatorIcons
        @Composable get() = LocalCalculatorIcons.current
}