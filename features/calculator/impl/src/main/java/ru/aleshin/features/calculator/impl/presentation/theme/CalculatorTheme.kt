package ru.aleshin.features.calculator.impl.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.core.ui.theme.tokens.MathCalculatorLanguage
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.*
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.LocalCalculatorIcons
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.LocalCalculatorStrings
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.englishSettingsString
import ru.aleshin.features.calculator.impl.presentation.theme.tokens.russianSettingsString

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun CalculatorTheme(content: @Composable () -> Unit) {
    val strings = when (MathCalculatorRes.language) {
        MathCalculatorLanguage.EN -> englishSettingsString
        MathCalculatorLanguage.RU -> russianSettingsString
    }

    CompositionLocalProvider(
        LocalCalculatorStrings provides strings,
        LocalCalculatorIcons provides baseCalculatorIcons,
        content = content,
    )
}