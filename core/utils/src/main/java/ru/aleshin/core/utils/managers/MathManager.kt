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

import ru.aleshin.core.utils.extensions.isNotMathOperator
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 05.03.2023.
 */
interface MathManager {

    fun calculateValue(current: String): Float

    class Base @Inject constructor() : MathManager {

        override fun calculateValue(current: String): Float {
            var result = 0f
            var multiply = 1f
            var lastOperator = '+'
            var number = ""
            var count = 0

            for (i in current.iterator()) {
                if (i.isNotMathOperator() || (count == 0 && i == '-')) number += i
                if (count == 0 && i != '-' || count != 0) {
                    if (!i.isNotMathOperator() || count == current.length - 1) {
                        if (lastOperator == '+' || lastOperator == '-') {
                            if (lastOperator == '-') if (i != '*' && i != '/') result -= number.toFloat()
                            if (lastOperator == '+') if (i != '*' && i != '/') result += number.toFloat()
                            if (i == '*' || i == '/') {
                                if (multiply != 1f) result += multiply
                                multiply = 1f
                                multiply = if (lastOperator == '-') -number.toFloat() else number.toFloat()
                            } else {
                                if (multiply != 1f) result += multiply
                                multiply = 1f
                            }
                        } else if (lastOperator == '*' || lastOperator == '/') {
                            if (lastOperator == '*') multiply *= number.toFloat()
                            if (lastOperator == '/') multiply /= number.toFloat()
                            if (count == current.length - 1) result += multiply
                        }
                        lastOperator = i
                        number = ""
                    }
                }
                count++
            }
            return result
        }
    }
}