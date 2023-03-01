package ru.aleshin.core.utils.platform.screenmodel.common

import kotlinx.coroutines.flow.Flow
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface Actor<E : BaseEvent, F : BaseEffect> {
    fun handleEvent(event: E): Flow<F>
}
