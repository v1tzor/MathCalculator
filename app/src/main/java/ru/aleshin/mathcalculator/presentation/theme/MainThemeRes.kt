package ru.aleshin.mathcalculator.presentation.theme

import androidx.compose.runtime.Composable
import ru.aleshin.mathcalculator.presentation.theme.tokens.*

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
object MainThemeRes {

    val strings: MainStrings
        @Composable get() = LocalMainStrings.current

    val dimens: MainDimens
        @Composable get() = LocalMainDimens.current

    val icons: MainIcons
        @Composable get() = LocalMainIcons.current
}