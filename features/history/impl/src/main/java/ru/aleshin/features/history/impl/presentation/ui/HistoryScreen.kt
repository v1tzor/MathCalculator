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
package ru.aleshin.features.history.impl.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.platform.screen.ScreenContent
import ru.aleshin.features.history.impl.presentation.theme.HistoryTheme
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryEvent
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryViewState
import ru.aleshin.features.history.impl.presentation.ui.screenmodel.rememberHistoryScreenModel
import ru.aleshin.features.history.impl.presentation.ui.views.HistoryTopAppBar
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
internal class HistoryScreen @Inject constructor() : Screen {

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() = ScreenContent(rememberHistoryScreenModel(), HistoryViewState()) {
        HistoryTheme {
            Scaffold(
                content = { paddingValues ->
                    HistoryContent(
                        modifier = Modifier.padding(paddingValues),
                        state = fetchState(),
                        onSelectedItem = { dispatchEvent(HistoryEvent.PressOnHistoryItem(it)) },
                        onDeleteItem = { dispatchEvent(HistoryEvent.DeleteHistoryItem(it)) },
                    )
                },
                topBar = {
                    HistoryTopAppBar(
                        onBackButtonClick = { dispatchEvent(HistoryEvent.PressBackButton) },
                    )
                },
            )
        }
    }
}