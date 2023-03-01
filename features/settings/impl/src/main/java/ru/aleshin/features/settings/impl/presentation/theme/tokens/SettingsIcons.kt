package ru.aleshin.features.settings.impl.presentation.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import ru.aleshin.features.settings.impl.R

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal data class SettingsIcons(
    val back: Int,
)

internal val baseSettingIcons = SettingsIcons(
    back = R.drawable.ic_back,
)

internal val LocalSettingsIcons = staticCompositionLocalOf<SettingsIcons> {
    error("Settings Icons is not provided")
}
