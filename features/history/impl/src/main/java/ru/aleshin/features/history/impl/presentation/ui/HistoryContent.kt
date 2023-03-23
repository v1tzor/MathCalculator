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

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.features.history.api.domain.entities.CalculateHistory
import ru.aleshin.features.history.impl.presentation.theme.HistoryThemeRes
import ru.aleshin.features.history.impl.presentation.ui.contract.HistoryViewState
import ru.aleshin.features.history.impl.presentation.ui.views.DateItem
import ru.aleshin.features.history.impl.presentation.ui.views.HistoryItem
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@Composable
internal fun HistoryContent(
    modifier: Modifier = Modifier,
    state: HistoryViewState,
    onSelectedItem: (CalculateHistory) -> Unit,
    onDeleteItem: (CalculateHistory) -> Unit,
) {
    val listState = rememberLazyListState()
    if (state.historyItems != null) {
        val historyItems = checkNotNull(state.historyItems)
        if (historyItems.isEmpty()) {
            Box(modifier = modifier.fillMaxSize()) {
                EmptyListView(Modifier.align(Alignment.Center))
            }
        } else {
            LazyColumn(
                modifier = modifier.fillMaxSize().animateContentSize(),
                state = listState,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                historyItems.forEachIndexed { index, history ->
                    if (index == 0 || (historyItems[index - 1].date != history.date)) {
                        item { DateItem(date = history.date) }
                    }
                    item {
                        HistoryItem(
                            mathResult = history.result,
                            mathInput = history.mathInput,
                            onItemClick = { onSelectedItem(history) },
                            onDeleteClick = { onDeleteItem(history) },
                        )
                    }
                }
                item { Spacer(modifier = Modifier.fillMaxWidth().height(60.dp)) }
            }
        }
    }
}

@Composable
internal fun EmptyListView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(64.dp),
            painter = painterResource(HistoryThemeRes.icons.empty),
            contentDescription = HistoryThemeRes.strings.emptyTitle,
            tint = MaterialTheme.colorScheme.surfaceVariant,
        )
        Text(
            text = HistoryThemeRes.strings.emptyTitle,
            color = MaterialTheme.colorScheme.surfaceVariant,
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

// @Composable
// @Preview(showBackground = true, showSystemUi = true)
// fun HistoryContent_Preview() {
//    MathCalculatorTheme() {
//        HistoryTheme {
//            HistoryContent(
//                state = HistoryViewState(),
//                onSelectedItem = {},
//                onDeleteItem = {},
//            )
//        }
//    }
// }