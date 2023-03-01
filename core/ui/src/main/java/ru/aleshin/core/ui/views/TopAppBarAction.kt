package ru.aleshin.core.ui.views

import androidx.compose.runtime.Composable

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface TopAppBarAction {
    val icon: Int? @Composable get
    val title: String @Composable get
    val isAlwaysShow: Boolean
}