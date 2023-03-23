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
package ru.aleshin.features.history.impl.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.features.history.impl.presentation.theme.HistoryThemeRes
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@Composable
internal fun DateItem(
    modifier: Modifier = Modifier,
    date: Date,
) {
    val dateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT)
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = dateFormat.format(date),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Divider(modifier = Modifier.weight(1f))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun HistoryItem(
    modifier: Modifier = Modifier,
    mathResult: String,
    mathInput: String,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = MathCalculatorRes.elevations.levelTwo,
        onClick = onItemClick,
    ) {
        Row(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 8.dp)) {
            Column(Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
                Text(
                    text = mathInput,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = mathResult,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = HistoryThemeRes.strings.deleteIconDesc,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}