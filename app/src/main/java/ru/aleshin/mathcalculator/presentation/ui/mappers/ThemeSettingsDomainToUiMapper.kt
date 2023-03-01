package ru.aleshin.mathcalculator.presentation.ui.mappers

import ru.aleshin.core.database.domain.entities.settings.LanguageType
import ru.aleshin.core.database.domain.entities.settings.ThemeColorsType
import ru.aleshin.core.ui.theme.material.ThemeColorsUiType
import ru.aleshin.core.ui.theme.tokens.LanguageUiType

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
fun LanguageType.mapToUi() = when (this) {
    LanguageType.DEFUALT -> LanguageUiType.DEFUALT
    LanguageType.EN -> LanguageUiType.EN
    LanguageType.RU -> LanguageUiType.RU
}

fun ThemeColorsType.mapToUi() = when (this) {
    ThemeColorsType.DEFUALT -> ThemeColorsUiType.DEFUALT
    ThemeColorsType.LIGHT -> ThemeColorsUiType.LIGHT
    ThemeColorsType.DARK -> ThemeColorsUiType.DARK
}