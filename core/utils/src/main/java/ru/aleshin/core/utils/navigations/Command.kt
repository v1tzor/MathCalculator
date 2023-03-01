package ru.aleshin.core.utils.navigations

import cafe.adriel.voyager.core.screen.Screen

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
sealed class Command {
    data class Forward(val screen: Screen) : Command()
    data class Replace(val screen: Screen) : Command()
    data class ReplaceAll(val screen: Screen) : Command()
    object Back : Command()
}
