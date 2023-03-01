package ru.aleshin.core.ui.theme.material

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
val baseDarkColorScheme = darkColorScheme(
    primary = Color(0xFF96CCFF),
    onPrimary = Color(0xFF003353),
    primaryContainer = Color(0xFF004A76),
    onPrimaryContainer = Color(0xFFCEE5FF),
    secondary = Color(0xFFB6C8DE),
    onSecondary = Color(0xFF203243),
    secondaryContainer = Color(0xFF37485A),
    onSecondaryContainer = Color(0xFFD2E4FA),
    tertiary = Color(0xFFD5BDEC),
    onTertiary = Color(0xFF3A294E),
    tertiaryContainer = Color(0xFF513F66),
    onTertiaryContainer = Color(0xFF513F66),
    background = Color(0xFF1A1C1E),
    onBackground = Color(0xFFE2E2E5),
    surface = Color(0xFF1A1C1E),
    onSurface = Color(0xFFE2E2E5),
    surfaceVariant = Color(0xFF42474E),
    onSurfaceVariant = Color(0xFFC2C7CF),
    outline = Color(0xFF8C9198),
    error = Color(0xFFFFB4AB),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFB4AB),
)

val baseLightColorScheme = lightColorScheme(
    primary = Color(0xFF00639A),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFCEE5FF),
    onPrimaryContainer = Color(0xFF001D32),
    secondary = Color(0xFF4E6073),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFCDE1F8),
    onSecondaryContainer = Color(0xFF0A1D2D),
    tertiary = Color(0xFF69567F),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFEEDBFF),
    onTertiaryContainer = Color(0xFF241338),
    surface = Color(0xFFFCFCFF),
    onSurface = Color(0xFF1A1C1E),
    surfaceVariant = Color(0xFFDEE3EB),
    onSurfaceVariant = Color(0xFF42474E),
    outline = Color(0xFF72777F),
    error = Color(0xFFBA1A1A),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
)

enum class ThemeColorsUiType {
    DEFUALT, LIGHT, DARK
}

@Composable
fun ThemeColorsUiType.toColorScheme(
    dynamicColor: Boolean,
) = if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    val context = LocalContext.current
    when (this) {
        ThemeColorsUiType.DEFUALT -> if (isSystemInDarkTheme()) {
            dynamicDarkColorScheme(context)
        } else {
            dynamicLightColorScheme(context)
        }
        ThemeColorsUiType.LIGHT -> dynamicLightColorScheme(context)
        ThemeColorsUiType.DARK -> dynamicDarkColorScheme(context)
    }
} else {
    when (this) {
        ThemeColorsUiType.DEFUALT -> if (isSystemInDarkTheme()) baseDarkColorScheme else baseLightColorScheme
        ThemeColorsUiType.LIGHT -> baseLightColorScheme
        ThemeColorsUiType.DARK -> baseDarkColorScheme
    }
}

@Composable
fun ThemeColorsUiType.isDarkTheme() = when (this) {
    ThemeColorsUiType.DEFUALT -> isSystemInDarkTheme()
    ThemeColorsUiType.LIGHT -> false
    ThemeColorsUiType.DARK -> true
}