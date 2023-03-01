package ru.aleshin.features.settings.impl.presentation.theme

import androidx.compose.runtime.Composable
import ru.aleshin.features.settings.impl.presentation.theme.tokens.LocalSettingsIcons
import ru.aleshin.features.settings.impl.presentation.theme.tokens.LocalSettingsStrings
import ru.aleshin.features.settings.impl.presentation.theme.tokens.SettingsIcons
import ru.aleshin.features.settings.impl.presentation.theme.tokens.SettingsStrings

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal object SettingsThemeRes {

    val strings: SettingsStrings
        @Composable get() = LocalSettingsStrings.current

    val icons: SettingsIcons
        @Composable get() = LocalSettingsIcons.current
}