package ru.aleshin.core.utils.navigations

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CommandListenerManager {
    fun setListener(listener: CommandListener)
    fun removeListener()
}

typealias CommandListener = (Command) -> Unit
