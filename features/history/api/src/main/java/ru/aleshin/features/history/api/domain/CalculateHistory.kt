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
package ru.aleshin.features.history.api.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.functional.Mapper
import java.util.Date

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
@Parcelize
data class CalculateHistory(
    val id: Int = 0,
    val result: String,
    val mathInput: String,
    val date: Date,
) : Parcelable {
    fun <T> map(mapper: Mapper<CalculateHistory, T>) = mapper.map(this)
}
