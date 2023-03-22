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

import ru.aleshin.core.utils.functional.Either
import ru.aleshin.core.utils.platform.screenmodel.work.*
import ru.aleshin.features.history.api.domain.CalculateHistory
import ru.aleshin.features.history.impl.domain.interactors.HistoryInteractor
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryAction
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal interface HistoryWorkProcessor :
    WorkProcessor<HistoryWorkCommand, HistoryAction, HistoryEffect> {

    class Base @Inject constructor(
        private val historyInteractor: HistoryInteractor,
    ) : HistoryWorkProcessor {

        override suspend fun work(command: HistoryWorkCommand) = when (command) {
            is HistoryWorkCommand.DeleteHistoryItem -> deleteHistoryItem(command.item)
            is HistoryWorkCommand.LoadAllHistory -> loadAllHistory()
        }

        private suspend fun deleteHistoryItem(item: CalculateHistory): WorkResult<HistoryAction, HistoryEffect> {
            return when (val either = historyInteractor.deleteHistoryItem(item)) {
                is Either.Right -> ActionResult(HistoryAction.DeleteHistoryItem(item))
                is Either.Left -> EffectResult(HistoryEffect.ShowFailure(either.data))
            }
        }

        private suspend fun loadAllHistory(): WorkResult<HistoryAction, HistoryEffect> {
            return when (val either = historyInteractor.fetchAllHistory()) {
                is Either.Right -> ActionResult(HistoryAction.SetHistoryItems(either.data))
                is Either.Left -> EffectResult(HistoryEffect.ShowFailure(either.data))
            }
        }
    }
}

internal sealed class HistoryWorkCommand : WorkCommand {
    object LoadAllHistory : HistoryWorkCommand()
    data class DeleteHistoryItem(val item: CalculateHistory) : HistoryWorkCommand()
}