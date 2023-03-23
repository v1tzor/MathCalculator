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

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.platform.screenmodel.BaseScreenModel
import ru.aleshin.core.utils.platform.screenmodel.work.WorkScope
import ru.aleshin.features.calculator.impl.di.holder.CalculatorComponentHolder
import ru.aleshin.features.calculator.impl.navigations.NavigationManager
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEvent
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class CalculatorScreenModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val calculateProcessor: CalculatorWorkProcessor,
    private val historyProcessor: HistoryWorkProcessor,
    stateCommunicator: CalculatorStateCommunicator,
    effectCommunicator: CalculatorEffectCommunicator,
    coroutineManager: CoroutineManager,
) : BaseScreenModel<CalculatorViewState, CalculatorEvent, CalculatorAction, CalculatorEffect>(
    stateCommunicator = stateCommunicator,
    effectCommunicator = effectCommunicator,
    coroutineManager = coroutineManager,
) {

    override suspend fun WorkScope<CalculatorViewState, CalculatorAction, CalculatorEffect>.handleEvent(
        event: CalculatorEvent,
    ) {
        when (event) {
            is CalculatorEvent.PressSettingsButton -> navigationManager.navigateToSettingsFeature()

            is CalculatorEvent.PressHistoryButton -> navigationManager.navigateToHistoryFeature()

            is CalculatorEvent.ClearLastNumber -> calculateProcessor.work(
                command = CalculatorWorkCommand.ClearLastNumber(state().currentValue),
            ).handleWork()

            is CalculatorEvent.SelectedNumber -> calculateProcessor.work(
                command = CalculatorWorkCommand.SelectedNumber(state().currentValue, event.number),
            ).handleWork()

            is CalculatorEvent.SelectedMathOperator -> calculateProcessor.work(
                CalculatorWorkCommand.ChangeMathOperator(state().currentValue, event.operator),
            ).handleWork()

            is CalculatorEvent.PressResultButton -> calculateProcessor.work(
                CalculatorWorkCommand.CalculateResult(state().currentValue),
            ).handleWork()

            is CalculatorEvent.CheckHistory -> historyProcessor.work(
                HistoryWorkCommand.CheckAndSetHistory,
            ).handleWork()

            is CalculatorEvent.ClearField -> {
                sendAction(CalculatorAction.ChangeResult(""))
                sendAction(CalculatorAction.ChangeCurrentValue(""))
            }
        }
    }

    override suspend fun reduce(
        action: CalculatorAction,
        currentState: CalculatorViewState,
    ) = when (action) {
        is CalculatorAction.ChangeCurrentValue -> currentState.copy(currentValue = action.value)
        is CalculatorAction.ChangeResult -> currentState.copy(result = action.result)
        is CalculatorAction.OnEmptyAction -> currentState.copy()
        is CalculatorAction.ChangeData -> currentState.copy(
            currentValue = action.value,
            result = action.result,
        )
    }

    override fun onDispose() {
        super.onDispose()
        CalculatorComponentHolder.clear()
    }
}

@Composable
internal fun Screen.rememberCalculatorScreenModel() = rememberScreenModel {
    CalculatorComponentHolder.fetchComponent().fetchCalculatorScreenModel()
}
