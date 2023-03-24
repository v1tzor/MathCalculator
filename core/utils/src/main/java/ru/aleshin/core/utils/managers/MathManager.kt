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

import ru.aleshin.core.utils.extensions.correctCalculatorRound
import ru.aleshin.core.utils.extensions.isNotMathOperator
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 05.03.2023.
 */
interface MathManager {

    fun calculateValue(current: String): Double

    class Base @Inject constructor() : MathManager {

        override fun calculateValue(current: String): Double {
            var result = 0.0
            var multiply: Double? = null
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
                                if (multiply != null) result += multiply
                                multiply = null
                                multiply = if (lastOperator == '-') -number.toDouble() else number.toDouble()
                            } else {
                                if (multiply != null) result += multiply
                                multiply = null
                            }
                        } else if (lastOperator == '*' || lastOperator == '/') {
                            if (lastOperator == '*') if (multiply != null) multiply *= number.toFloat() else multiply = number.toDouble()
                            if (lastOperator == '/') if (multiply != null) multiply /= number.toFloat() else multiply = number.toDouble()
                            if (count == current.length - 1) if (multiply != null) result += multiply
                        }
                        lastOperator = i
                        number = ""
                    }
                }
                count++
            }
            return result.correctCalculatorRound()
        }
    }
}