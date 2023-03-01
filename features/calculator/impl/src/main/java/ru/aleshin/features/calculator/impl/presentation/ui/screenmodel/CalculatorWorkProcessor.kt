package ru.aleshin.features.calculator.impl.presentation.ui.screenmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import ru.aleshin.core.utils.managers.MathManager
import ru.aleshin.core.utils.platform.screenmodel.common.WorkCommand
import ru.aleshin.core.utils.platform.screenmodel.common.WorkProcessor
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorAction
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEffect
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface CalculatorWorkProcessor : WorkProcessor<CalculatorWorkCommand, CalculatorEffect> {

    fun addNumber(number: String, current: String): Flow<CalculatorEffect>
    fun calculateDifference(current: String): Flow<CalculatorEffect>
    fun calculateSum(current: String): Flow<CalculatorEffect>
    fun clearResult(current: String): Flow<CalculatorEffect>
    fun calculateResult(current: String): Flow<CalculatorEffect>

    class Base @Inject constructor(
        private val mathManager: MathManager,
    ) : CalculatorWorkProcessor {

        override fun addNumber(number: String, current: String) =
            work(CalculatorWorkCommand.AddNumber(number, current))

        override fun calculateDifference(current: String) =
            work(CalculatorWorkCommand.CalculateDifference(current))

        override fun calculateSum(current: String) =
            work(CalculatorWorkCommand.CalculateSum(current))

        override fun calculateResult(current: String) =
            work(CalculatorWorkCommand.CalculateResult(current))

        override fun clearResult(current: String) =
            work(CalculatorWorkCommand.Clear(current))

        override fun work(command: CalculatorWorkCommand) = when (command) {
            is CalculatorWorkCommand.CalculateDifference -> flow<CalculatorEffect> {
                val difference = mathManager.countDifference(command.current)
                if (difference != null) {
                    emit(CalculatorAction.ChangeCurrentValue(difference))
                    emit(CalculatorAction.ChangeIsPlus(false))
                }
            }

            is CalculatorWorkCommand.CalculateSum -> flow {
                val summa = mathManager.countSum(command.current)
                if (summa != null) {
                    emit(CalculatorAction.ChangeCurrentValue(summa))
                    emit(CalculatorAction.ChangeIsPlus(true))
                }
            }

            is CalculatorWorkCommand.CalculateResult -> flow {
                val result = mathManager.countResult(command.current)
                emit(CalculatorAction.ChangeCurrentValue(result))
            }.catch { emit(CalculatorAction.ChangeCurrentValue("-1")) }

            is CalculatorWorkCommand.Clear -> flow {
                val result = command.current
                if (result.isNotEmpty()) {
                    emit(CalculatorAction.ChangeCurrentValue(result.substring(0, result.length - 1)))
                }
            }
            is CalculatorWorkCommand.AddNumber -> flow {
                emit(CalculatorAction.ChangeCurrentValue(command.current + command.number))
            }
        }
    }
}

internal sealed class CalculatorWorkCommand : WorkCommand {
    data class CalculateSum(val current: String) : CalculatorWorkCommand()
    data class CalculateDifference(val current: String) : CalculatorWorkCommand()
    data class CalculateResult(val current: String) : CalculatorWorkCommand()
    data class AddNumber(val number: String, val current: String) : CalculatorWorkCommand()
    data class Clear(val current: String) : CalculatorWorkCommand()
}