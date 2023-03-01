package ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel

import ru.aleshin.core.utils.platform.communications.state.StateCommunicator
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SplashStateCommunicator : StateCommunicator<SplashViewState> {

    class Base @Inject constructor() : SplashStateCommunicator,
        StateCommunicator.Abstract<SplashViewState>(defualtState = SplashViewState.Defualt)
}
