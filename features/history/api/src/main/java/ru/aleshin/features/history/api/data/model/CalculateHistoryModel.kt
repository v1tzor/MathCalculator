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
package ru.aleshin.features.history.api.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aleshin.core.utils.functional.Mapper
import java.util.*

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
@Entity(tableName = "CalculatorHistory")
data class CalculateHistoryModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("math_result") val mathResult: String,
    @ColumnInfo("math_input") val mathInput: String,
    @ColumnInfo("date_save") val dateSave: Long,
) {
    fun <T> map(mapper: Mapper<CalculateHistoryModel, T>) = mapper.map(this)
}