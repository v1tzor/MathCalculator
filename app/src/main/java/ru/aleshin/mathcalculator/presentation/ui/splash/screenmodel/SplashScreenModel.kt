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
package ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.platform.screenmodel.BaseScreenModel
import ru.aleshin.mathcalculator.application.fetchAppComponent
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashAction
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEffect
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEvent
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
class SplashScreenModel @Inject constructor(
    private val navigationManager: ru.aleshin.mathcalculator.navigation.GlobalNavigationManager,
    communicator: SplashStateCommunicator,
    actor: SplashActor,
    coroutineManager: CoroutineManager,
) : BaseScreenModel<SplashViewState, SplashEvent, SplashAction, SplashEffect>(
    stateCommunicator = communicator,
    actor = actor,
    coroutineManager = coroutineManager,
) {
    override fun handleEffect(effect: SplashEffect) = when (effect) {
        is SplashEffect.NavigateToCalculator -> navigationManager.navigateToCalculatorFeature()
        is SplashAction -> runOnBackground {
            val currentState = stateCommunicator.read()
            val newState = reduce(effect, currentState)

            stateCommunicator.update(newState)
        }
    }

    override fun reduce(
        action: SplashAction,
        currentState: SplashViewState,
    ) = SplashViewState.Defualt
}

@Composable
fun Screen.rememberSplashScreenModel(): SplashScreenModel {
    val component = fetchAppComponent()
    return rememberScreenModel { component.fetchSplashScreenModel() }
}
