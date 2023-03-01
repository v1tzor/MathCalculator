package ru.aleshin.core.utils.navigations

import cafe.adriel.voyager.navigator.Navigator

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface NavigationProcessor {

    fun navigate(command: Command, navigator: Navigator)

    class Base : NavigationProcessor {
        override fun navigate(command: Command, navigator: Navigator) {
            with(navigator) {
                when (command) {
                    is Command.Forward -> push(command.screen)
                    is Command.Replace -> replace(command.screen)
                    is Command.ReplaceAll -> replaceAll(command.screen)
                    is Command.Back -> pop()
                }
            }
        }
    }
}