package ru.aleshin.features.settings.impl.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.aleshin.core.database.domain.entities.settings.ThemeColorsType
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.core.ui.views.SegmentedButtonItem
import ru.aleshin.core.ui.views.SegmentedButtons
import ru.aleshin.features.settings.impl.presentation.theme.SettingsThemeRes

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
internal fun ThemeColorsChooser(
    modifier: Modifier = Modifier,
    currentThemeColors: ThemeColorsType,
    onThemeColorUpdate: (ThemeColorsType) -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        tonalElevation = MathCalculatorRes.elevations.levelTwo,
    ) {
        Column(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = SettingsThemeRes.strings.mainSettingsThemeTitle,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium,
            )
            SegmentedButtons(
                modifier = Modifier.fillMaxWidth(),
                items = ThemeColorsTypeSegmentedItems.values(),
                selectedItem = currentThemeColors.toSegmentedItem(),
                onItemClick = { onThemeColorUpdate.invoke(it.toThemeColorsType()) },
            )
        }
    }
}

internal enum class ThemeColorsTypeSegmentedItems : SegmentedButtonItem {
    LIGHT {
        override val title: String @Composable get() = SettingsThemeRes.strings.lightThemeTitle
    },
    DEFUALT {
        override val title: String @Composable get() = SettingsThemeRes.strings.systemThemeTitle
    },
    DARK {
        override val title: String @Composable get() = SettingsThemeRes.strings.darkThemeTitle
    },
}

internal fun ThemeColorsType.toSegmentedItem() = when (this) {
    ThemeColorsType.DEFUALT -> ThemeColorsTypeSegmentedItems.DEFUALT
    ThemeColorsType.LIGHT -> ThemeColorsTypeSegmentedItems.LIGHT
    ThemeColorsType.DARK -> ThemeColorsTypeSegmentedItems.DARK
}

internal fun ThemeColorsTypeSegmentedItems.toThemeColorsType() = when (this) {
    ThemeColorsTypeSegmentedItems.LIGHT -> ThemeColorsType.LIGHT
    ThemeColorsTypeSegmentedItems.DEFUALT -> ThemeColorsType.DEFUALT
    ThemeColorsTypeSegmentedItems.DARK -> ThemeColorsType.DARK
}
