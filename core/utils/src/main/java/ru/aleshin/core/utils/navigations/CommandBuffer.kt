package ru.aleshin.core.utils.navigations

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CommandBuffer : CommandListenerManager {

    fun sendCommand(command: Command)

    class Base : CommandBuffer {

        private val commandBuffer = mutableListOf<Command>()
        private var commandListener: CommandListener? = null

        override fun sendCommand(command: Command) {
            commandListener?.invoke(command) ?: commandBuffer.add(command)
        }

        override fun setListener(listener: CommandListener) {
            this.commandListener = listener

            commandBuffer.forEach { listener.invoke(it) }
            commandBuffer.clear()
        }

        override fun removeListener() {
            commandListener = null
        }
    }
}
