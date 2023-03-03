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

import kotlinx.coroutines.flow.flowOf
import ru.aleshin.core.utils.platform.screenmodel.common.Actor
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEffect
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEvent
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SplashActor : Actor<SplashEvent, SplashEffect> {

    class Base @Inject constructor() : SplashActor {
        override fun handleEvent(event: SplashEvent) = when (event) {
            SplashEvent.AfterSplash -> flowOf(SplashEffect.NavigateToCalculator)
        }
    }
}
