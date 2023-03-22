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
package ru.aleshin.features.calculator.impl.navigations

import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.features.calculator.api.CalculatorFeatureStarter
import ru.aleshin.features.calculator.impl.domain.interactors.CalculatorInteractor
import ru.aleshin.features.history.api.domain.CalculateHistory
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class CalculatorFeatureStarterImpl @Inject constructor(
    private val calculatorScreen: Screen,
    private val calculatorInteractor: CalculatorInteractor,
) : CalculatorFeatureStarter {

    override suspend fun provideMainScreen(history: CalculateHistory?): Screen {
        return when (val either = calculatorInteractor.sendHistory(history)) {
            is Either.Right -> calculatorScreen
            is Either.Left -> error("Error send history to calculator feature. Failure: ${either.data}")
        }
    }
}