package ru.aleshin.core.utils.platform.screenmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.FlowCollector
import ru.aleshin.core.utils.managers.CoroutineBlock
import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.platform.communications.state.StateCommunicator
import ru.aleshin.core.utils.platform.communications.state.ViewStateCollect
import ru.aleshin.core.utils.platform.screenmodel.common.Actor
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
abstract class BaseScreenModel<S : BaseViewState, E : BaseEvent, A : BaseAction, F : BaseEffect>(
    protected val stateCommunicator: StateCommunicator<S>,
    private val actor: Actor<E, F>,
    private val coroutineManager: CoroutineManager,
) : ScreenModel, ViewStateCollect<S> {

    override suspend fun collectState(collector: FlowCollector<S>) {
        stateCommunicator.collect(collector)
    }

    fun dispatchEvent(event: E) = runOnBackground {
        actor.handleEvent(event).collect { effect -> handleEffect(effect) }
    }

    protected fun runOnBackground(block: CoroutineBlock) {
        coroutineManager.runOnBackground(coroutineScope, block)
    }

    protected abstract fun handleEffect(effect: F)

    protected abstract fun reduce(action: A, currentState: S): S
}
