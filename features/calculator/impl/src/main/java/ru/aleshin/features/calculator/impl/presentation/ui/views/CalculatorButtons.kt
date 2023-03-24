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
package ru.aleshin.features.calculator.impl.presentation.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.features.calculator.impl.presentation.theme.CalculatorThemeRes

/**
 * @author Stanislav Aleshin on 02.03.2023.
 */
@Composable
internal fun NumberButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
    title: String,
) {
    Surface(
        modifier = modifier.sizeIn(minHeight = 36.dp).fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick.invoke(title) },
        shape = MaterialTheme.shapes.medium,
        tonalElevation = MathCalculatorRes.elevations.levelOne,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}

@Composable
internal fun ActionButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    color: Color = MaterialTheme.colorScheme.secondaryContainer,
    title: String,
) {
    Surface(
        modifier = modifier.sizeIn(minHeight = 36.dp).fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick.invoke(title) },
        shape = MaterialTheme.shapes.small,
        color = color,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Composable
internal fun ActionResultButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val title = CalculatorThemeRes.strings.resultButtonTitle
    Surface(
        modifier = modifier.sizeIn(minHeight = 36.dp).fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}