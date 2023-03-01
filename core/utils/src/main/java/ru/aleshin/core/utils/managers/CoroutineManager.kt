package ru.aleshin.core.utils.managers

import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CoroutineManager {

    fun runOnBackground(scope: CoroutineScope, block: CoroutineBlock): Job

    fun runOnUi(scope: CoroutineScope, block: CoroutineBlock): Job

    suspend fun changeFlow(coroutineFlow: CoroutineFlow, block: CoroutineBlock)

    abstract class Abstract(
        private val backgroundDispatcher: CoroutineDispatcher,
        private val uiDispatcher: CoroutineDispatcher,
    ) : CoroutineManager {

        override fun runOnBackground(scope: CoroutineScope, block: CoroutineBlock): Job {
            return scope.launch(context = backgroundDispatcher, block = block)
        }

        override fun runOnUi(scope: CoroutineScope, block: CoroutineBlock): Job {
            return scope.launch(context = uiDispatcher, block = block)
        }

        override suspend fun changeFlow(coroutineFlow: CoroutineFlow, block: CoroutineBlock) {
            val dispatcher = when (coroutineFlow) {
                CoroutineFlow.BACKGROUND -> backgroundDispatcher
                CoroutineFlow.UI -> uiDispatcher
            }
            withContext(context = dispatcher, block = block)
        }
    }

    class Base @Inject constructor() : Abstract(
        backgroundDispatcher = Dispatchers.IO,
        uiDispatcher = Dispatchers.Main,
    )
}

typealias CoroutineBlock = suspend CoroutineScope.() -> Unit

enum class CoroutineFlow {
    BACKGROUND, UI
}
