package ru.aleshin.features.calculator.impl.data.datasource

import kotlinx.coroutines.sync.Mutex
import ru.aleshin.core.utils.platform.screenmodel.withReentrantLock
import ru.aleshin.features.history.api.domain.CalculateHistory
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal interface CalculatorLocalDataSource {

    suspend fun saveHistory(model: CalculateHistory?)

    fun readHistory(): CalculateHistory?

    class Base @Inject constructor() : CalculatorLocalDataSource {

        private val mutex = Mutex()
        private var history: CalculateHistory? = null

        override suspend fun saveHistory(model: CalculateHistory?) = mutex.withReentrantLock {
            history = model
        }

        override fun readHistory(): CalculateHistory? {
            return history
        }
    }
}