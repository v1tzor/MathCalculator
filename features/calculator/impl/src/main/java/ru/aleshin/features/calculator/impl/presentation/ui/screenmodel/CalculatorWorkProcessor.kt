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

import ru.aleshin.core.utils.extensions.isNotMathOperator
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.core.utils.managers.DateManager
import ru.aleshin.core.utils.managers.MathManager
import ru.aleshin.core.utils.platform.screenmodel.work.*
import ru.aleshin.features.calculator.impl.domain.interactors.HistoryInteractor
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import ru.aleshin.features.history.api.domain.entities.CalculateHistory
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface CalculatorWorkProcessor :
    WorkProcessor<CalculatorWorkCommand, CalculatorAction, CalculatorEffect> {

    class Base @Inject constructor(
        private val interactor: HistoryInteractor,
        private val dateManager: DateManager,
        private val mathManger: MathManager,
    ) : CalculatorWorkProcessor {

        override suspend fun work(command: CalculatorWorkCommand) = when (command) {
            is CalculatorWorkCommand.Calculate -> try {
                calculateWork(command.current)
            } catch (e: Exception) {
                ActionResult(CalculatorAction.ChangeResult("-1"))
            }
            is CalculatorWorkCommand.CalculateResult -> calculateResultWork(command.current)
            is CalculatorWorkCommand.ChangeMathOperator -> changeMathOperatorWork(command.current, command.operator)
            is CalculatorWorkCommand.SelectedNumber -> selectedNumberWork(command.current, command.number)
            is CalculatorWorkCommand.ClearLastNumber -> clearLastNumberWork(command.current)
        }

        private fun clearLastNumberWork(current: String): WorkResult<CalculatorAction, CalculatorEffect> {
            val newValue = if (current.isNotEmpty()) current.substring(0, current.length - 1) else ""
            return if (newValue.isEmpty()) {
                ActionResult(CalculatorAction.ChangeData("", ""))
            } else {
                if (newValue.last().isNotMathOperator() && newValue.last() != '.') {
                    val newResult = mathManger.calculateValue(newValue).toString()
                    ActionResult(CalculatorAction.ChangeData(newValue, newResult))
                } else {
                    ActionResult(CalculatorAction.ChangeData(newValue, ""))
                }
            }
        }

        private suspend fun calculateResultWork(current: String): WorkResult<CalculatorAction, CalculatorEffect> {
            val newValue = mathManger.calculateValue(current).toString()
            val savableItem = CalculateHistory(
                result = newValue,
                mathInput = current,
                date = dateManager.fetchBeginningCurrentDay(),
            )
            return when (val either = interactor.saveResultToHistory(savableItem)) {
                is Either.Right -> ActionResult(CalculatorAction.ChangeData(newValue, ""))
                is Either.Left -> EffectResult(CalculatorEffect.ShowFailure(either.data))
            }
        }

        private fun changeMathOperatorWork(
            current: String,
            operator: String,
        ): WorkResult<CalculatorAction, CalculatorEffect> {
            return if (current.isNotEmpty()) {
                if (current.last().isNotMathOperator()) {
                    if (operator == ".") {
                        val lastOperator =
                            current.indexOfLast { it == '-' || it == '+' || it == '*' || it == '/' }
                        val lastDot = current.indexOfLast { it == '.' }
                        if (lastDot > lastOperator) return ActionResult(CalculatorAction.OnEmptyAction)
                    }
                    ActionResult(CalculatorAction.ChangeData(value = current + operator, result = ""))
                } else {
                    if (current.last().toString() != operator && current.length != 1) {
                        val value = current.substring(0, current.length - 1) + operator
                        ActionResult(CalculatorAction.ChangeData(value = value, result = ""))
                    } else {
                        ActionResult(CalculatorAction.OnEmptyAction)
                    }
                }
            } else if (operator == "-") {
                ActionResult(CalculatorAction.ChangeCurrentValue(operator))
            } else {
                ActionResult(CalculatorAction.OnEmptyAction)
            }
        }

        private fun selectedNumberWork(
            current: String,
            number: String,
        ): WorkResult<CalculatorAction, CalculatorEffect> {
            val newValue = current + number
            val newResult = mathManger.calculateValue(newValue).toString()
            return ActionResult(CalculatorAction.ChangeData(newValue, newResult))
        }

        private fun calculateWork(current: String): WorkResult<CalculatorAction, CalculatorEffect> {
            return if (current.isNotEmpty() && current.last().isNotMathOperator()) {
                ActionResult(
                    CalculatorAction.ChangeResult(
                        mathManger.calculateValue(current).toString(),
                    ),
                )
            } else {
                ActionResult(CalculatorAction.OnEmptyAction)
            }
        }
    }
}

internal sealed class CalculatorWorkCommand : WorkCommand {
    data class Calculate(val current: String) : CalculatorWorkCommand()
    data class ClearLastNumber(val current: String) : CalculatorWorkCommand()
    data class CalculateResult(val current: String) : CalculatorWorkCommand()
    data class SelectedNumber(val current: String, val number: String) : CalculatorWorkCommand()
    data class ChangeMathOperator(val current: String, val operator: String) :
        CalculatorWorkCommand()
}