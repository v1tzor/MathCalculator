package ru.aleshin.features.settings.impl.presentation.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal data class SettingsStrings(
    val settingsTitle: String,
    val mainSettingsTitle: String,
    val mainSettingsThemeTitle: String,
    val darkThemeTitle: String,
    val lightThemeTitle: String,
    val systemThemeTitle: String,
    val mainSettingsLanguageTitle: String,
    val backIconDesc: String,
    val moreIconDesc: String,
    val resetToDefualtTitle: String,
)

internal val russianSettingsString = SettingsStrings(
    settingsTitle = "Настройки",
    mainSettingsTitle = "Основные настройки",
    mainSettingsThemeTitle = "Тема:",
    darkThemeTitle = "Тёмная",
    lightThemeTitle = "Светлая",
    systemThemeTitle = "Системная",
    mainSettingsLanguageTitle = "Язык приложения",
    backIconDesc = "Назад",
    moreIconDesc = "Дополнительно",
    resetToDefualtTitle = "По умолчанию",
)

internal val englishSettingsString = SettingsStrings(
    settingsTitle = "Settings",
    mainSettingsTitle = "General settings",
    mainSettingsThemeTitle = "Theme:",
    darkThemeTitle = "Dark",
    lightThemeTitle = "Light",
    systemThemeTitle = "System",
    mainSettingsLanguageTitle = "App language",
    backIconDesc = "Navigate up",
    moreIconDesc = "More",
    resetToDefualtTitle = "Reset to defualt",
)

internal val LocalSettingsStrings = staticCompositionLocalOf<SettingsStrings> {
    error("Settings Strings is not provided")
}
