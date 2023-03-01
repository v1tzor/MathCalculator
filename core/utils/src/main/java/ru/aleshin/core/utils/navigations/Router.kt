package ru.aleshin.core.utils.navigations

import cafe.adriel.voyager.core.screen.Screen

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface Router {

    fun navigateTo(screen: Screen)

    fun replaceTo(screen: Screen, isAll: Boolean = false)

    fun navigateBack()

    abstract class Abstract constructor(private val commandBuffer: CommandBuffer) : Router {

        override fun navigateTo(screen: Screen) {
            commandBuffer.sendCommand(Command.Forward(screen))
        }

        override fun replaceTo(screen: Screen, isAll: Boolean) {
            val command = if (isAll) Command.ReplaceAll(screen) else Command.Replace(screen)
            commandBuffer.sendCommand(command)
        }

        override fun navigateBack() {
            commandBuffer.sendCommand(Command.Back)
        }
    }

    class Base constructor(commandBuffer: CommandBuffer) : Router, Abstract(commandBuffer)
}

interface TabRouter {

    fun showTab(screen: Screen)

    class Base constructor(private val router: Router) : TabRouter {
        override fun showTab(screen: Screen) {
            router.replaceTo(screen = screen, isAll = true)
        }
    }
}
