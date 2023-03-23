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
package ru.aleshin.features.history.api.data.mappers

import ru.aleshin.core.utils.extensions.mapToDate
import ru.aleshin.core.utils.functional.Mapper
import ru.aleshin.features.history.api.data.model.CalculateHistoryModel
import ru.aleshin.features.history.api.domain.entities.CalculateHistory
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
interface CalculatorHistoryDataToDomainMapper : Mapper<CalculateHistoryModel, CalculateHistory> {
    class Base @Inject constructor() : CalculatorHistoryDataToDomainMapper {
        override fun map(input: CalculateHistoryModel) = CalculateHistory(
            id = input.id,
            result = input.mathResult,
            mathInput = input.mathInput,
            date = input.dateSave.mapToDate(),
        )
    }
}

interface CalculatorHistoryDomainToDataMapper : Mapper<CalculateHistory, CalculateHistoryModel> {
    class Base @Inject constructor() : CalculatorHistoryDomainToDataMapper {
        override fun map(input: CalculateHistory) = CalculateHistoryModel(
            id = input.id,
            mathResult = input.result,
            mathInput = input.mathInput,
            dateSave = input.date.time,
        )
    }
}