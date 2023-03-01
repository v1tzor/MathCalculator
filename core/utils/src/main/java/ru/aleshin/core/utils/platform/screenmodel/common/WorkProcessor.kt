package ru.aleshin.core.utils.platform.screenmodel.common

import kotlinx.coroutines.flow.Flow
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface WorkProcessor<C : WorkCommand, E : BaseEffect> {
    fun work(command: C): Flow<E>
}

interface WorkCommand
