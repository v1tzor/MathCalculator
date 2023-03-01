package ru.aleshin.features.settings.impl.presentation.ui.screensmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.aleshin.core.utils.platform.screenmodel.common.Actor
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsEffect
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsEvent
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsActor : Actor<SettingsEvent, SettingsEffect> {

    class Base @Inject constructor(
        private val settingsWorkProcessor: SettingsWorkProcessor,
    ) : SettingsActor {

        override fun handleEvent(event: SettingsEvent): Flow<SettingsEffect> = when (event) {
            is SettingsEvent.PressBackButton -> flowOf(SettingsEffect.ShowPreviousFeature)
            is SettingsEvent.Init -> settingsWorkProcessor.loadAllSettings()
            is SettingsEvent.ChangedThemeSettings -> settingsWorkProcessor.updateThemeSettings(event.themeSettings)
        }
    }
}