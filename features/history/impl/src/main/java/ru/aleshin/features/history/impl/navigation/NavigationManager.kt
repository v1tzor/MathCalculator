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
package ru.aleshin.features.history.impl.navigation

import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.features.calculator.api.navigation.CalculatorFeatureStarter
import ru.aleshin.features.history.api.domain.entities.CalculateHistory
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
internal interface NavigationManager {

    suspend fun showCalculatorFeature(history: CalculateHistory)

    fun showPreviousFeature()

    class Base @Inject constructor(
        private val calculatorStarter: Provider<CalculatorFeatureStarter>,
        private val globalRouter: Router,
    ) : NavigationManager {

        override suspend fun showCalculatorFeature(history: CalculateHistory) {
            val screen = calculatorStarter.get().provideMainScreen(history)
            globalRouter.replaceTo(screen, true)
        }

        override fun showPreviousFeature() {
            globalRouter.navigateBack()
        }
    }
}