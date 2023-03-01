package ru.aleshin.core.utils.platform.screenmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
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
import javax.inject.Provider

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
abstract class BaseViewModel<S : BaseViewState, E : BaseEvent, A : BaseAction, F : BaseEffect>(
    protected val stateCommunicator: StateCommunicator<S>,
    private val actor: Actor<E, F>,
    private val coroutineManager: CoroutineManager,
) : ViewModel(), ViewStateCollect<S> {

    override suspend fun collectState(collector: FlowCollector<S>) {
        stateCommunicator.collect(collector)
    }

    fun dispatchEvent(event: E) = runOnBackground {
        actor.handleEvent(event).collect { effect -> handleEffect(effect) }
    }

    protected fun runOnBackground(block: CoroutineBlock) {
        coroutineManager.runOnBackground(viewModelScope, block)
    }

    protected abstract fun handleEffect(effect: F)

    protected abstract fun reduce(action: A, currentState: S): S

    abstract class Factory(
        private val viewModel: Provider<out ViewModel>,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModel.get() as T
        }
    }
}
