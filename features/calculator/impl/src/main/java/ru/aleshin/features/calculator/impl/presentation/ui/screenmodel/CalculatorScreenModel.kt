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
    communicator: CalculatorStateCommunicator,
    actor: CalculatorActor,
    coroutineManager: CoroutineManager,
) : BaseScreenModel<CalculatorViewState, CalculatorEvent, CalculatorAction, CalculatorEffect>(
    stateCommunicator = communicator,
    actor = actor,
    coroutineManager = coroutineManager,
) {
    override fun handleEffect(effect: CalculatorEffect) = when (effect) {
        is CalculatorEffect.ShowSettingsFeature -> navigationManager.navigateToSettingsFeature()
        is CalculatorAction -> runOnBackground {
            val currentState = stateCommunicator.read()
            val newState = reduce(effect, currentState)

            stateCommunicator.update(newState)
        }
    }

    override fun reduce(
        action: CalculatorAction,
        currentState: CalculatorViewState,
    ) = when (action) {
        is CalculatorAction.ChangeCurrentValue -> currentState.copy(currentValue = action.value)
        is CalculatorAction.ChangeIsPlus -> currentState.copy(isPlus = action.isPlus)
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
