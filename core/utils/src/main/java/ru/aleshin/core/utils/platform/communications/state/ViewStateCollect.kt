package ru.aleshin.core.utils.platform.communications.state

import kotlinx.coroutines.flow.FlowCollector
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface ViewStateCollect<S : BaseViewState> {
    suspend fun collectState(collector: FlowCollector<S>)
}
