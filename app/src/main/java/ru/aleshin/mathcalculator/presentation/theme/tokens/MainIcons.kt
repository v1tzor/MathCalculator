package ru.aleshin.mathcalculator.presentation.theme.tokens

import androidx.compose.runtime.compositionLocalOf
import ru.aleshin.mathcalculator.R

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MainIcons(
    val launcher: Int,
)

val baseMainIcons = MainIcons(
    launcher = R.drawable.ic_calculate,
)

val LocalMainIcons = compositionLocalOf<MainIcons> {
    error("Main Icons is not provided")
}