package ru.aleshin.features.calculator.impl.presentation.ui.screenmodel

import kotlinx.coroutines.flow.Flow
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
            is CalculatorEvent.ClearField -> flowOf(CalculatorAction.ChangeCurrentValue(""))
            is CalculatorEvent.SumNumbers -> calculateProcessor.calculateSum(event.current)
            is CalculatorEvent.DifferenceNumbers -> calculateProcessor.calculateDifference(event.current)
            is CalculatorEvent.PressResultButton -> calculateProcessor.calculateResult(event.current)
            is CalculatorEvent.SelectedNumber -> calculateProcessor.addNumber(event.number, event.current)
            is CalculatorEvent.ClearLastNumber -> calculateProcessor.clearResult(event.current)
        }
    }
}