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
package ru.aleshin.features.history.impl.presentation.ui.screenmodel

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.platform.screenmodel.BaseScreenModel
import ru.aleshin.core.utils.platform.screenmodel.work.WorkScope
import ru.aleshin.features.history.impl.di.holder.HistoryComponentHolder
import ru.aleshin.features.history.impl.navigation.NavigationManager
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryAction
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryEffect
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryEvent
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryViewState
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal class HistoryScreenModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val historyWorkProcessor: HistoryWorkProcessor,
    stateCommunicator: HistoryStateCommunicator,
    effectCommunicator: HistoryEffectCommunicator,
    coroutineManager: CoroutineManager,
) : BaseScreenModel<HistoryViewState, HistoryEvent, HistoryAction, HistoryEffect>(
    stateCommunicator = stateCommunicator,
    effectCommunicator = effectCommunicator,
    coroutineManager = coroutineManager,
) {

    init {
        dispatchEvent(HistoryEvent.Init)
    }

    override suspend fun WorkScope<HistoryViewState, HistoryAction, HistoryEffect>.handleEvent(
        event: HistoryEvent,
    ) = when (event) {
        is HistoryEvent.PressBackButton -> navigationManager.showPreviousFeature()
        is HistoryEvent.PressOnHistoryItem -> navigationManager.showCalculatorFeature(event.item)
        is HistoryEvent.Init -> {
            historyWorkProcessor.work(HistoryWorkCommand.LoadAllHistory).handleWork()
        }
        is HistoryEvent.DeleteHistoryItem -> {
            historyWorkProcessor.work(HistoryWorkCommand.DeleteHistoryItem(event.item)).handleWork()
        }
    }

    override suspend fun reduce(
        action: HistoryAction,
        currentState: HistoryViewState,
    ) = when (action) {
        is HistoryAction.SetHistoryItems -> currentState.copy(historyItems = action.items)
        is HistoryAction.DeleteHistoryItem -> currentState.copy(
            historyItems = currentState.historyItems?.toMutableList().apply {
                checkNotNull(this).remove(action.item)
            },
        )
    }
}

@Composable
internal fun Screen.rememberHistoryScreenModel() = rememberScreenModel {
    HistoryComponentHolder.fetchComponent().fetchHistoryScreenModel()
}
