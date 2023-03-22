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
package ru.aleshin.features.calculator.impl.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.platform.screen.ScreenContent
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
    override fun Content() = ScreenContent(rememberCalculatorScreenModel(), CalculatorViewState()) {
        CalculatorTheme {
            Scaffold(
                content = { paddingValues ->
                    CalculatorContent(
                        modifier = Modifier.padding(paddingValues),
                        state = fetchState(),
                        onNumberSelected = { dispatchEvent(CalculatorEvent.SelectedNumber(it)) },
                        onOperatorSelected = { dispatchEvent(CalculatorEvent.SelectedMathOperator(it)) },
                        onResultButtonClick = { dispatchEvent(CalculatorEvent.PressResultButton) },
                        onClearAllButtonClick = { dispatchEvent(CalculatorEvent.ClearField) },
                        onClearLastButtonClick = { dispatchEvent(CalculatorEvent.ClearLastNumber) },
                    )
                },
                topBar = {
                    CalculatorTopAppBar(
                        onSettingsButtonClick = { dispatchEvent(CalculatorEvent.PressSettingsButton) },
                        onHistoryButtonClick = { dispatchEvent(CalculatorEvent.PressHistoryButton) },
                    )
                },
            )

            LaunchedEffect(Unit) { dispatchEvent(CalculatorEvent.CheckHistory) }
        }
    }
}