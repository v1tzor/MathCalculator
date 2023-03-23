package ru.aleshin.features.settings.impl.presentation.mappers

import androidx.compose.runtime.Composable
import ru.aleshin.features.settings.api.domain.entities.LanguageType
import ru.aleshin.features.settings.impl.presentation.theme.SettingsThemeRes

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@Composable
fun LanguageType.toLanguageName(): String = when (this) {
    LanguageType.DEFUALT -> SettingsThemeRes.strings.defualtLanguageTitle
    LanguageType.EN -> SettingsThemeRes.strings.engLanguageTitle
    LanguageType.RU -> SettingsThemeRes.strings.rusLanguageTitle
}