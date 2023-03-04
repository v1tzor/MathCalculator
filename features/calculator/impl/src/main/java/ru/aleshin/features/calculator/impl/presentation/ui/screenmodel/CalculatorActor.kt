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
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import ru.aleshin.core.utils.platform.screenmodel.common.Actor
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEvent
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface CalculatorActor : Actor<CalculatorEvent, CalculatorEffect> {

    class Base @Inject constructor(
        private val calculateProcessor: CalculatorWorkProcessor,
    ) : CalculatorActor {

        override fun handleEvent(event: CalculatorEvent): Flow<CalculatorEffect> = when (event) {
            is CalculatorEvent.PressSettingsButton -> flowOf(CalculatorEffect.ShowSettingsFeature)
            is CalculatorEvent.ClearField -> flow {
                emit(CalculatorAction.ChangeResult(""))
                emit(CalculatorAction.ChangeCurrentValue(""))
            }
            is CalculatorEvent.ClearLastNumber -> flow {
                val current = event.current
                val newValue = if (current.isNotEmpty()) current.substring(0, current.length - 1) else ""
                if (newValue.isEmpty()) {
                    emit(CalculatorAction.ChangeResult(""))
                    emit(CalculatorAction.ChangeCurrentValue(""))
                } else {
                    emit(CalculatorAction.ChangeCurrentValue(newValue))
                    emitAll(calculateProcessor.calculate(newValue))
                }
            }
            is CalculatorEvent.SelectedNumber -> flow {
                val newValue = event.current + event.number
                emit(CalculatorAction.ChangeCurrentValue(newValue))
                emitAll(calculateProcessor.calculate(newValue))
            }
            is CalculatorEvent.SelectedMathOperator -> {
                calculateProcessor.changeMathOperator(event.current, event.operator)
            }
            is CalculatorEvent.PressResultButton -> {
                calculateProcessor.calculateResult(event.result)
            }
        }
    }
}