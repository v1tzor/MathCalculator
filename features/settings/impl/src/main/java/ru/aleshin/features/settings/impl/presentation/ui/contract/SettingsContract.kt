package ru.aleshin.features.settings.impl.presentation.ui.contract // ktlint-disable filename

import kotlinx.parcelize.Parcelize
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState
import ru.aleshin.features.settings.impl.domain.common.SettingsFailures
import ru.aleshin.features.settings.impl.domain.entities.Settings

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
internal data class SettingsViewState(
    val themeSettings: ThemeSettings? = null,
    val failure: SettingsFailures? = null,
) : BaseViewState

internal sealed class SettingsEvent : BaseEvent {
    object Init : SettingsEvent()
    object PressBackButton : SettingsEvent()
    data class ChangedThemeSettings(val themeSettings: ThemeSettings) : SettingsEvent()
}

internal sealed class SettingsEffect : BaseEffect {
    object ShowPreviousFeature : SettingsEffect()
}

internal sealed class SettingsAction : SettingsEffect(), BaseAction {
    data class ChangeAllSettings(val settings: Settings) : SettingsAction()
    data class ChangeThemeSettings(val settings: ThemeSettings) : SettingsAction()
    data class ShowError(val failures: SettingsFailures) : SettingsAction()
}