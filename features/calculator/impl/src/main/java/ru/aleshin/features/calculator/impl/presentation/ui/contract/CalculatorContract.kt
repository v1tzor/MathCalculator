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
package ru.aleshin.features.calculator.impl.presentation.ui.contract

import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
internal data class CalculatorViewState(
    val currentValue: String = "",
    val result: String = "",
) : BaseViewState

internal sealed class CalculatorEvent : BaseEvent {
    data class SelectedNumber(val number: String) : CalculatorEvent()
    data class SelectedMathOperator(val operator: String) : CalculatorEvent()
    object PressResultButton : CalculatorEvent()
    object ClearLastNumber : CalculatorEvent()
    object ClearField : CalculatorEvent()
    object PressSettingsButton : CalculatorEvent()
}

internal sealed class CalculatorEffect : BaseEffect {
    object ShowSettingsFeature : CalculatorEffect()
}

internal sealed class CalculatorAction : CalculatorEffect(), BaseAction {
    data class ChangeCurrentValue(val value: String) : CalculatorAction()
    data class ChangeResult(val result: String) : CalculatorAction()
    data class ChangeData(val value: String, val result: String) : CalculatorAction()
}