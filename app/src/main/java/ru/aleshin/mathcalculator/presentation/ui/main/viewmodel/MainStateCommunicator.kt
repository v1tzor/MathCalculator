package ru.aleshin.mathcalculator.presentation.ui.main.viewmodel

import ru.aleshin.core.utils.platform.communications.state.StateCommunicator
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface MainStateCommunicator : StateCommunicator<MainViewState> {

    class Base @Inject constructor() : MainStateCommunicator,
        StateCommunicator.Abstract<MainViewState>(defualtState = MainViewState())
}
