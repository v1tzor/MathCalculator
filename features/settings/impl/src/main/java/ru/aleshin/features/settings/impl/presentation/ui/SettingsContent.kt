package ru.aleshin.features.settings.impl.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.aleshin.core.database.domain.entities.settings.LanguageType
import ru.aleshin.core.database.domain.entities.settings.ThemeColorsType
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.core.ui.theme.material.ThemeColorsUiType
import ru.aleshin.core.ui.theme.tokens.LanguageUiType
import ru.aleshin.features.settings.impl.presentation.theme.SettingsTheme
import ru.aleshin.features.settings.impl.presentation.theme.SettingsThemeRes
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsViewState
import ru.aleshin.features.settings.impl.presentation.ui.views.ThemeColorsChooser

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun SettingsContent(
    state: SettingsViewState,
    onUpdateThemeSettings: (ThemeSettings) -> Unit,
) {
    if (state.themeSettings != null) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = SettingsThemeRes.strings.mainSettingsTitle,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge,
                )
                ThemeColorsChooser(
                    modifier = Modifier.fillMaxWidth(),
                    currentThemeColors = state.themeSettings.themeColors,
                    onThemeColorUpdate = { colorsType ->
                        onUpdateThemeSettings.invoke(state.themeSettings.copy(themeColors = colorsType))
                    },
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SettingsContent_Preview() {
    MathCalculatorTheme(
        dynamicColor = false,
        themeColorsType = ThemeColorsUiType.LIGHT,
        language = LanguageUiType.RU,
    ) {
        SettingsTheme {
            val state = SettingsViewState(
                themeSettings = ThemeSettings(LanguageType.RU, ThemeColorsType.LIGHT),
            )
            SettingsContent(
                state = state,
                onUpdateThemeSettings = {},
            )
        }
    }
}