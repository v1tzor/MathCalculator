package ru.aleshin.mathcalculator.presentation.theme.tokens

import androidx.compose.runtime.compositionLocalOf

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MainStrings(
    val authorTitle: String,
    val launcherIconDesc: String,
)

val englishMainStrings = MainStrings(
    authorTitle = "Created by Aleshin Stanislav",
    launcherIconDesc = "Math Calculator",
)

val russianMainStrings = MainStrings(
    authorTitle = "Created by Aleshin Stanislav",
    launcherIconDesc = "Math Calculator",
)

val LocalMainStrings = compositionLocalOf<MainStrings> {
    error("Splash strings is not provided")
}