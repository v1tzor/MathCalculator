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
package ru.aleshin.features.history.impl.presentation.ui.contract

import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseUiEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState
import ru.aleshin.features.history.api.domain.entities.CalculateHistory
import ru.aleshin.features.history.impl.domain.entities.HistoryFailures

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@Parcelize
internal data class HistoryViewState(
    val historyItems: List<CalculateHistory>? = null,
) : BaseViewState

internal sealed class HistoryEvent : BaseEvent {
    object Init : HistoryEvent()
    object PressBackButton : HistoryEvent()
    data class PressOnHistoryItem(val item: CalculateHistory) : HistoryEvent()
    data class DeleteHistoryItem(val item: CalculateHistory) : HistoryEvent()
}

internal sealed class HistoryEffect : BaseUiEffect {
    data class ShowFailure(val failure: HistoryFailures) : HistoryEffect()
}

internal sealed class HistoryAction : HistoryEffect(), BaseAction {
    data class SetHistoryItems(val items: List<CalculateHistory>) : HistoryAction()
    data class DeleteHistoryItem(val item: CalculateHistory) : HistoryAction()
}