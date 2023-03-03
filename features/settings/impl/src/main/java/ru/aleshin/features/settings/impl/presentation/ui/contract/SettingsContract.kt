/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
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