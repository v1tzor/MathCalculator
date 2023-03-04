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
package ru.aleshin.features.calculator.impl.presentation.ui.screenmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import ru.aleshin.core.utils.platform.screenmodel.common.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.common.WorkProcessor
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface CalculatorWorkProcessor : WorkProcessor<CalculatorWorkCommand, CalculatorEffect> {

    fun calculate(current: String): Flow<CalculatorEffect>
    fun calculateResult(current: String): Flow<CalculatorEffect>
    fun changeMathOperator(current: String, operator: String): Flow<CalculatorEffect>

    class Base @Inject constructor() : CalculatorWorkProcessor {
        override fun calculate(current: String) = work(
            command = CalculatorWorkCommand.Calculate(current),
        )

        override fun calculateResult(current: String) = work(
            command = CalculatorWorkCommand.CalculateResult(current),
        )

        override fun changeMathOperator(current: String, operator: String) = work(
            command = CalculatorWorkCommand.ChangeMathOperator(current, operator),
        )

        override fun work(command: CalculatorWorkCommand) = when (command) {
            is CalculatorWorkCommand.Calculate -> {
                calculateWork(command.current).catch { emit(CalculatorAction.ChangeResult("-1")) }
            }
            is CalculatorWorkCommand.CalculateResult -> flow {
                emit(CalculatorAction.ChangeCurrentValue(command.result))
                emit(CalculatorAction.ChangeResult(""))
            }
            is CalculatorWorkCommand.ChangeMathOperator -> flow {
                val current = command.current
                val operator = command.operator
                if (current.isNotEmpty()) {
                    if (current.last().isNotMathOperator()) {
                        if (operator == ".") {
                            val lastOperator =
                                current.indexOfLast { it == '-' || it == '+' || it == '*' || it == '/' }
                            val lastDot = current.indexOfLast { it == '.' }
                            if (lastDot > lastOperator) return@flow
                        }
                        val newValue = current + operator
                        emit(CalculatorAction.ChangeCurrentValue(newValue))
                        emitAll(calculateWork(newValue))
                    } else {
                        if (current.last().toString() != operator && current.length != 1) {
                            val newValue = current.substring(0, current.length - 1) + operator
                            emit(CalculatorAction.ChangeCurrentValue(newValue))
                        }
                    }
                } else if (operator == "-") {
                    emit(CalculatorAction.ChangeCurrentValue(operator))
                }
            }
        }

        private fun calculateWork(current: String) = flow<CalculatorEffect> {
            if (current.isNotEmpty() && current.last().isNotMathOperator()) {
                emit(CalculatorAction.ChangeResult(calculateValue(current).toString()))
            }
        }

        private fun calculateValue(current: String): Float {
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

internal fun Char.isNotMathOperator() = this != '-' && this != '+' && this != '*' && this != '/'
internal sealed class CalculatorWorkCommand : WorkCommand {
    data class Calculate(val current: String) : CalculatorWorkCommand()
    data class CalculateResult(val result: String) : CalculatorWorkCommand()
    data class ChangeMathOperator(val current: String, val operator: String) :
        CalculatorWorkCommand()
}