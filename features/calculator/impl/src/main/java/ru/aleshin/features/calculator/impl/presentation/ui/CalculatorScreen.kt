package ru.aleshin.features.calculator.impl.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.platform.screen.rememberViewState
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorTheme
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorEvent
import ru.aleshin.features.calculator.impl.presentation.ui.contract.CalculatorViewState
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.rememberCalculatorScreenModel
import ru.aleshin.features.calculator.impl.presentation.ui.views.CalculatorTopAppBar
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class CalculatorScreen @Inject constructor() : Screen {

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        val screenModel = rememberCalculatorScreenModel()
        val state = rememberViewState(screenModel, CalculatorViewState())

        CalculatorTheme {
            Scaffold(
                content = {
                    CalculatorContent(
                        modifier = Modifier.padding(it),
                        state = state,
                        onClearAction = { screenModel.dispatchEvent(CalculatorEvent.ClearField) },
                        onClearLastAction = { screenModel.dispatchEvent(CalculatorEvent.ClearLastNumber(state.currentValue)) },
                        onNumberSelected = { screenModel.dispatchEvent(CalculatorEvent.SelectedNumber(it, state.currentValue)) },
                        onDifferenceAction = { screenModel.dispatchEvent(CalculatorEvent.DifferenceNumbers(state.currentValue)) },
                        onSumAction = { screenModel.dispatchEvent(CalculatorEvent.SumNumbers(state.currentValue)) },
                        onResultAction = { screenModel.dispatchEvent(CalculatorEvent.PressResultButton(state.currentValue)) },
                    )
                },
                topBar = {
                    CalculatorTopAppBar(
                        onSettingsButtonClick = { screenModel.dispatchEvent(CalculatorEvent.PressSettingsButton) },
                    )
                },
            )
        }
    }
}