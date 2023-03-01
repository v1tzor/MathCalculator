package ru.aleshin.core.utils.platform.communications.state

import ru.aleshin.core.utils.platform.communications.Communicator
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface StateCommunicator<S : BaseViewState> : Communicator<S> {

    abstract class Abstract<S : BaseViewState>(defualtState: S) : StateCommunicator<S>,
        Communicator.AbstractStateFlow<S>(defualtState)
}
