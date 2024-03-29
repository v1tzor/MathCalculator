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
package ru.aleshin.features.calculator.impl.presentation.ui.screenmodel

import ru.aleshin.core.utils.functional.Either
import ru.aleshin.core.utils.platform.screenmodel.work.ActionResult
import ru.aleshin.core.utils.platform.screenmodel.work.EffectResult
import ru.aleshin.core.utils.platform.screenmodel.work.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.work.WorkProcessor
import ru.aleshin.features.calculator.impl.domain.interactors.CalculatorInteractor
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal interface HistoryWorkProcessor : WorkProcessor<HistoryWorkCommand, CalculatorAction, CalculatorEffect> {

    class Base @Inject constructor(
        private val interactor: CalculatorInteractor,
    ) : HistoryWorkProcessor {
        override suspend fun work(command: HistoryWorkCommand) = when (command) {
            HistoryWorkCommand.CheckAndSetHistory -> {
                when (val either = interactor.readSendHistory()) {
                    is Either.Left -> EffectResult(CalculatorEffect.ShowFailure(either.data))
                    is Either.Right -> either.data?.let {
                        ActionResult(CalculatorAction.ChangeData(it.mathInput, it.result))
                    } ?: ActionResult(CalculatorAction.OnEmptyAction)
                }
            }
        }
    }
}

internal sealed class HistoryWorkCommand : WorkCommand {
    object CheckAndSetHistory : HistoryWorkCommand()
}