package ru.aleshin.mathcalculator.presentation.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MainDimens(
    val launcherIcon: Dp,
    val authorTitlePadding: Dp,
)

val baseMainDimens = MainDimens(
    launcherIcon = 64.dp,
    authorTitlePadding = 18.dp,
)

val LocalMainDimens = staticCompositionLocalOf<MainDimens> {
    error("Main Dimens is not provided")
}