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

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import ru.aleshin.core.utils.extensions.isNotMathOperator
import ru.aleshin.core.utils.managers.MathManager
import ru.aleshin.core.utils.platform.screenmodel.common.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.common.WorkProcessor
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface CalculatorWorkProcessor : WorkProcessor<CalculatorWorkCommand, CalculatorEffect> {

    class Base @Inject constructor(
        private val stateCommunicator: CalculatorStateCommunicator,
        private val mathManger: MathManager,
    ) : CalculatorWorkProcessor {
        override fun work(command: CalculatorWorkCommand) = when (command) {
            is CalculatorWorkCommand.Calculate -> calculateWork().catch { emit(CalculatorAction.ChangeResult("-1")) }
            is CalculatorWorkCommand.CalculateResult -> calculateResultWork()
            is CalculatorWorkCommand.ChangeMathOperator -> changeMathOperatorWork(command.operator)
            is CalculatorWorkCommand.SelectedNumber -> selectedNumberWork(command.number)
            is CalculatorWorkCommand.ClearLastNumber -> clearLastNumberWork()
        }

        private fun clearLastNumberWork() = flow<CalculatorEffect> {
            val current = stateCommunicator.read().currentValue
            val newValue = if (current.isNotEmpty()) current.substring(0, current.length - 1) else ""
            if (newValue.isEmpty()) {
                emit(CalculatorAction.ChangeData("", ""))
            } else {
                if (newValue.last().isNotMathOperator()) {
                    val newResult = mathManger.calculateValue(newValue).toString()
                    emit(CalculatorAction.ChangeData(newValue, newResult))
                } else {
                    emit(CalculatorAction.ChangeCurrentValue(newValue))
                }
            }
        }

        private fun calculateResultWork() = flow {
            val current = stateCommunicator.read().currentValue
            val newValue = mathManger.calculateValue(current).toString()
            emit(CalculatorAction.ChangeData(newValue, ""))
        }

        private fun changeMathOperatorWork(operator: String) = flow {
            val current = stateCommunicator.read().currentValue
            if (current.isNotEmpty()) {
                if (current.last().isNotMathOperator()) {
                    if (operator == ".") {
                        val lastOperator = current.indexOfLast { it == '-' || it == '+' || it == '*' || it == '/' }
                        val lastDot = current.indexOfLast { it == '.' }
                        if (lastDot > lastOperator) return@flow
                    }
                    emit(CalculatorAction.ChangeCurrentValue(current + operator))
                } else {
                    if (current.last().toString() != operator && current.length != 1) {
                        emit(CalculatorAction.ChangeCurrentValue(current.substring(0, current.length - 1) + operator))
                    }
                }
            } else if (operator == "-") {
                emit(CalculatorAction.ChangeCurrentValue(operator))
            }
        }

        private fun selectedNumberWork(number: String) = flow {
            val current = stateCommunicator.read().currentValue
            val newValue = current + number
            val newResult = mathManger.calculateValue(newValue).toString()
            emit(CalculatorAction.ChangeData(newValue, newResult))
        }

        private fun calculateWork() = flow<CalculatorEffect> {
            val current = stateCommunicator.read().currentValue
            if (current.isNotEmpty() && current.last().isNotMathOperator()) {
                emit(CalculatorAction.ChangeResult(mathManger.calculateValue(current).toString()))
            }
        }
    }
}

internal sealed class CalculatorWorkCommand : WorkCommand {
    object Calculate : CalculatorWorkCommand()
    object ClearLastNumber : CalculatorWorkCommand()
    object CalculateResult : CalculatorWorkCommand()
    data class SelectedNumber(val number: String) : CalculatorWorkCommand()
    data class ChangeMathOperator(val operator: String) : CalculatorWorkCommand()
}