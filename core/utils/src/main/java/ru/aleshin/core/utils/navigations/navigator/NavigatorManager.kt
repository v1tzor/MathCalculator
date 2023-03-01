package ru.aleshin.core.utils.navigations.navigator

import cafe.adriel.voyager.navigator.Navigator
import ru.aleshin.core.utils.navigations.CommandBuffer
import ru.aleshin.core.utils.navigations.NavigationProcessor

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface NavigatorManager {

    fun attachNavigator(navigator: Navigator)

    fun detachNavigator()

    class Base(
        private val commandBuffer: CommandBuffer,
        private val navigationProcessor: NavigationProcessor = NavigationProcessor.Base(),
    ) : NavigatorManager {

        var navigator: Navigator? = null

        override fun attachNavigator(navigator: Navigator) {
            this.navigator = navigator

            commandBuffer.setListener { command ->
                navigationProcessor.navigate(command, checkNotNull(this.navigator))
            }
        }

        override fun detachNavigator() {
            commandBuffer.removeListener()
            navigator = null
        }
    }
}
