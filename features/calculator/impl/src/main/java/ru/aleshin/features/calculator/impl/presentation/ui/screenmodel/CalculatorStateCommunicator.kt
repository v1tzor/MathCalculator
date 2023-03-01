package ru.aleshin.features.calculator.impl.presentation.ui.screenmodel

import ru.aleshin.core.utils.platform.communications.state.StateCommunicator
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface CalculatorStateCommunicator : StateCommunicator<CalculatorViewState> {

    class Base @Inject constructor() : CalculatorStateCommunicator,
        StateCommunicator.Abstract<CalculatorViewState>(defualtState = CalculatorViewState())
}