package ru.aleshin.features.calculator.impl.data.repositories

import ru.aleshin.features.calculator.impl.data.datasource.CalculatorLocalDataSource
import ru.aleshin.features.calculator.impl.domain.repositories.CalculatorRepository
import ru.aleshin.features.history.api.domain.entities.CalculateHistory
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal class CalculatorRepositoryImpl @Inject constructor(
    private val localDataSource: CalculatorLocalDataSource,
) : CalculatorRepository {

    override suspend fun sendHistoryItem(item: CalculateHistory?) {
        localDataSource.saveHistory(item)
    }

    override suspend fun readHistoryItem(): CalculateHistory? {
        return localDataSource.readHistory().apply {
            localDataSource.saveHistory(null)
        }
    }
}