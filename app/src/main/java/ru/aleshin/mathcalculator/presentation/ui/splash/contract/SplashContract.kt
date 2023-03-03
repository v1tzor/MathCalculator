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
package ru.aleshin.mathcalculator.presentation.ui.splash.contract // ktlint-disable filename

import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
sealed class SplashViewState : BaseViewState {
    object Defualt : SplashViewState()
}

sealed class SplashEvent : BaseEvent {
    object AfterSplash : SplashEvent()
}

sealed class SplashEffect : BaseEffect {
    object NavigateToCalculator : SplashEffect()
}

sealed class SplashAction : SplashEffect(), BaseAction
