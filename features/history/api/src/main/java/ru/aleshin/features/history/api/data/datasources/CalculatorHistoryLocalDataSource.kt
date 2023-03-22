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
package ru.aleshin.features.history.api.data.datasources

import ru.aleshin.features.history.api.data.model.CalculateHistoryModel
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
interface CalculatorHistoryLocalDataSource {

    suspend fun fetchAllHistoryItems(): List<CalculateHistoryModel>
    suspend fun addHistoryItem(item: CalculateHistoryModel)
    suspend fun deleteHistoryItem(item: CalculateHistoryModel)

    class Base @Inject constructor(
        private val dao: CalculatorHistoryDao,
    ) : CalculatorHistoryLocalDataSource {

        override suspend fun fetchAllHistoryItems(): List<CalculateHistoryModel> {
            return dao.fetchAllHistoryItems()
        }

        override suspend fun addHistoryItem(item: CalculateHistoryModel) {
            dao.addHistoryItem(item)
        }

        override suspend fun deleteHistoryItem(item: CalculateHistoryModel) {
            dao.deleteHistoryItem(item)
        }
    }
}