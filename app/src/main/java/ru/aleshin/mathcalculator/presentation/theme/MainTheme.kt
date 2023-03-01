package ru.aleshin.mathcalculator.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.core.ui.theme.tokens.MathCalculatorLanguage
import ru.aleshin.mathcalculator.presentation.theme.tokens.*

/**
 * @author Stanislav Aleshin on 17.02.2023.
 */
@Composable
fun MainTheme(content: @Composable () -> Unit) {
    val strings = when (MathCalculatorRes.language) {
        MathCalculatorLanguage.EN -> englishMainStrings
        MathCalculatorLanguage.RU -> russianMainStrings
    }
    val dimens = baseMainDimens
    val icons = baseMainIcons

    CompositionLocalProvider(
        LocalMainStrings provides strings,
        LocalMainDimens provides dimens,
        LocalMainIcons provides icons,
        content = content,
    )
}