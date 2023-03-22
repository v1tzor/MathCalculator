/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package ru.aleshin.features.history.api.data.repositories

import ru.aleshin.features.history.api.data.datasources.CalculatorHistoryLocalDataSource
import ru.aleshin.features.history.api.data.mappers.CalculatorHistoryDataToDomainMapper
import ru.aleshin.features.history.api.data.mappers.CalculatorHistoryDomainToDataMapper
import ru.aleshin.features.history.api.domain.CalculateHistory
import ru.aleshin.features.history.api.domain.repositories.CalculatorHistoryRepository
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
class CalculatorHistoryRepositoryImpl @Inject constructor(
    private val localDataSource: CalculatorHistoryLocalDataSource,
    private val mapperToDomain: CalculatorHistoryDataToDomainMapper,
    private val mapperToData: CalculatorHistoryDomainToDataMapper,
) : CalculatorHistoryRepository {

    override suspend fun fetchAllHistory(): List<CalculateHistory> {
        return localDataSource.fetchAllHistoryItems().map { it.map(mapperToDomain) }
    }

    override suspend fun addHistoryItem(item: CalculateHistory) {
        localDataSource.addHistoryItem(item.map(mapperToData))
    }

    override suspend fun deleteHistoryItem(item: CalculateHistory) {
        localDataSource.deleteHistoryItem(item.map(mapperToData))
    }
}