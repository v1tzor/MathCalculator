package ru.aleshin.features.settings.impl.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.core.ui.theme.tokens.MathCalculatorLanguage
import ru.aleshin.features.settings.impl.presentation.theme.tokens.*
import ru.aleshin.features.settings.impl.presentation.theme.tokens.LocalSettingsIcons
import ru.aleshin.features.settings.impl.presentation.theme.tokens.LocalSettingsStrings
import ru.aleshin.features.settings.impl.presentation.theme.tokens.baseSettingIcons
import ru.aleshin.features.settings.impl.presentation.theme.tokens.englishSettingsString
import ru.aleshin.features.settings.impl.presentation.theme.tokens.russianSettingsString

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun SettingsTheme(content: @Composable () -> Unit) {
    val strings = when (MathCalculatorRes.language) {
        MathCalculatorLanguage.EN -> englishSettingsString
        MathCalculatorLanguage.RU -> russianSettingsString
    }

    CompositionLocalProvider(
        LocalSettingsStrings provides strings,
        LocalSettingsIcons provides baseSettingIcons,
        content = content,
    )
}