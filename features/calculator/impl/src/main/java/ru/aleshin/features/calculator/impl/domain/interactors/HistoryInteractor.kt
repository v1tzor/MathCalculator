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
package ru.aleshin.features.calculator.impl.domain.interactors

import ru.aleshin.core.utils.functional.UnitDomainResult
import ru.aleshin.features.calculator.impl.domain.common.CalculatorEitherWrapper
import ru.aleshin.features.calculator.impl.domain.entities.CalculatorFailures
import ru.aleshin.features.history.api.domain.CalculateHistory
import ru.aleshin.features.history.api.domain.repositories.CalculatorHistoryRepository
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal interface HistoryInteractor {

    suspend fun saveResultToHistory(item: CalculateHistory): UnitDomainResult<CalculatorFailures>

    class Base @Inject constructor(
        private val repository: CalculatorHistoryRepository,
        private val eitherWrapper: CalculatorEitherWrapper,
    ) : HistoryInteractor {

        override suspend fun saveResultToHistory(item: CalculateHistory) = eitherWrapper.wrap {
            repository.addHistoryItem(item)
        }
    }
}