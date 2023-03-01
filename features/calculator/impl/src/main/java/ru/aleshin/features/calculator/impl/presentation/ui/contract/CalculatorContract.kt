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
    val currentValue: String = "0",
    val isPlus: Boolean = false,
) : BaseViewState

internal sealed class CalculatorEvent : BaseEvent {
    object PressSettingsButton : CalculatorEvent()
    data class SelectedNumber(val number: String, val current: String) : CalculatorEvent()
    data class SumNumbers(val current: String) : CalculatorEvent()
    data class DifferenceNumbers(val current: String) : CalculatorEvent()
    data class ClearLastNumber(val current: String) : CalculatorEvent()
    object ClearField : CalculatorEvent()
    data class PressResultButton(val current: String) : CalculatorEvent()
}

internal sealed class CalculatorEffect : BaseEffect {
    object ShowPreviousFeature : CalculatorEffect()
    object ShowSettingsFeature : CalculatorEffect()
}

internal sealed class CalculatorAction : CalculatorEffect(), BaseAction {
    data class ChangeCurrentValue(val value: String) : CalculatorAction()
    data class ChangeIsPlus(val isPlus: Boolean) : CalculatorAction()
}