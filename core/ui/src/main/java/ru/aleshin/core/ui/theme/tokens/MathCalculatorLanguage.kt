package ru.aleshin.core.ui.theme.tokens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
enum class MathCalculatorLanguage(val code: String) {
    EN("en"), RU("ru")
}

enum class LanguageUiType {
    DEFUALT, EN, RU
}

val LocalMathCalculatorLanguage = staticCompositionLocalOf<MathCalculatorLanguage> {
    error("Language is not provided")
}

@Composable
fun MathCalculatorLocale() = when (Locale.current.language) {
    "ru" -> MathCalculatorLanguage.RU
    "en" -> MathCalculatorLanguage.EN
    else -> MathCalculatorLanguage.EN
}
