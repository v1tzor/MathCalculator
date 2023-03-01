package ru.aleshin.mathcalculator.presentation.ui.main.viewmodel

import ru.aleshin.core.utils.platform.screenmodel.common.Actor
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainEffect
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainEvent
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface MainActor : Actor<MainEvent, MainEffect> {

    class Base @Inject constructor(
        private val settingsWorkProcessor: SettingsWorkProcessor,
    ) : MainActor {
        override fun handleEvent(event: MainEvent) = when (event) {
            is MainEvent.Init -> settingsWorkProcessor.loadThemeSettings()
        }
    }
}
