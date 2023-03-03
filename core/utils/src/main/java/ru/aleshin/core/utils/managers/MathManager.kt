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

import ru.aleshin.core.utils.functional.Constants
import javax.inject.Inject

/**
 * The math logic required by the courses
 *
 * @author Stanislav Aleshin on 02.03.2023.
 */
interface MathManager {

    fun countSum(value: String): String?
    fun countDifference(value: String): String?
    fun countResult(value: String): String

    class Base @Inject constructor() : MathManager {

        override fun countSum(value: String): String? {
            var result: String? = null
            val allChars: CharArray = value.toCharArray()
            val lastSymbol: Char
            if (value.length !== 0) {
                lastSymbol = allChars[value.length - 1]
                if (lastSymbol.toString() == Constants.Symbols.PLUS || lastSymbol.toString() == Constants.Symbols.MINUS) {
                    val chars: CharArray = value.toCharArray()
                    chars[value.length - 1] = '+'
                    result = String(chars)
                } else {
                    if (!value.contains(Constants.Symbols.MINUS) || !value.contains(Constants.Symbols.PLUS)) {
                        result = "$value+"
                    }
                }
            }
            return result
        }

        override fun countDifference(value: String): String? {
            var result: String? = null
            val allChars: CharArray = value.toCharArray()
            val lastSymbol: Char
            if (value.length !== 0) {
                lastSymbol = allChars[value.length - 1]
                if (lastSymbol.toString() == Constants.Symbols.PLUS || lastSymbol.toString() == Constants.Symbols.MINUS) {
                    val chars: CharArray = value.toCharArray()
                    chars[value.length - 1] = '-'
                    result = String(chars)
                } else {
                    if (!value.contains(Constants.Symbols.MINUS) || !value.contains(Constants.Symbols.PLUS)) {
                        result = "$value-"
                    }
                }
            }
            return result
        }

        override fun countResult(current: String): String {
            val argResult: String = current
            var result = ""
            val plusPosition = argResult.indexOf("+")
            val minusPosition = argResult.indexOf("-")
            if (plusPosition == -1 && minusPosition == -1) {
                return ""
            }
            if (plusPosition != -1) {
                val firstValue = argResult.substring(0, plusPosition)
                val secondValue = argResult.substring(plusPosition + 1, argResult.length)
                val intResult: Int = Integer.valueOf(firstValue) + Integer.valueOf(secondValue)
                result = ""
                return intResult.toString()
            } else {
                if (minusPosition != -1) {
                    val firstValue = argResult.substring(0, minusPosition)
                    val secondValue = argResult.substring(minusPosition + 1, argResult.length)
                    val intResult: Int = Integer.valueOf(firstValue) - Integer.valueOf(secondValue)
                    result = ""
                    return intResult.toString()
                }
            }
            return ""
        }
    }
}