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
package ru.aleshin.core.utils.managers

import ru.aleshin.core.utils.extensions.*
import java.util.*
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
interface DateManager {

    fun fetchCurrentDate(): Date
    fun fetchBeginningCurrentDay(): Date
    fun fetchEndCurrentDay(): Date

    class Base @Inject constructor(
        private val calendar: Calendar,
    ) : DateManager {

        override fun fetchCurrentDate() = checkNotNull(calendar.time)

        override fun fetchBeginningCurrentDay(): Date {
            val currentCalendar = Calendar.getInstance().apply { time = calendar.time }
            return currentCalendar.setStartDay().time
        }

        override fun fetchEndCurrentDay(): Date {
            val currentCalendar = Calendar.getInstance().apply { time = calendar.time }
            return currentCalendar.setEndDay().time
        }
    }
}