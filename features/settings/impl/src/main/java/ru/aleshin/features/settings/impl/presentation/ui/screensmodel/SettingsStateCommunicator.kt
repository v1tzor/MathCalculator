package ru.aleshin.features.settings.impl.presentation.ui.screensmodel

import ru.aleshin.core.utils.platform.communications.state.StateCommunicator
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsStateCommunicator : StateCommunicator<SettingsViewState> {

    class Base @Inject constructor() : SettingsStateCommunicator,
        StateCommunicator.Abstract<SettingsViewState>(defualtState = SettingsViewState())
}