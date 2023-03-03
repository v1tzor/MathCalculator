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
package ru.aleshin.core.ui.views

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SegmentedButtonItem {
    val title: String
        @Composable
        @ReadOnlyComposable
        get
}

@Composable
fun <Item : SegmentedButtonItem> SegmentedButtons(
    modifier: Modifier = Modifier,
    items: Array<Item>,
    selectedItem: Item,
    onItemClick: (Item) -> Unit,
) {
    val buttonWidth = remember { mutableStateOf(SegmentedButtonDefaults.defualtWidth) }
    val density = LocalDensity.current
    Row(
        modifier = modifier
            .onGloballyPositioned {
                buttonWidth.value = density.run { (it.size.width / items.size).toDp() }
            }
            .animateContentSize(),
    ) {
        items.forEachIndexed { index, item ->
            if (index == 0) {
                SegmentedButton(
                    modifier = Modifier.width(buttonWidth.value),
                    title = item.title,
                    isSelected = item == selectedItem,
                    shape = SegmentedButtonDefaults.firstButtonShape(),
                    onClick = { onItemClick.invoke(item) },
                )
            } else if (items.lastIndex == index) {
                SegmentedButton(
                    modifier = Modifier.width(buttonWidth.value),
                    title = item.title,
                    isSelected = item == selectedItem,
                    shape = SegmentedButtonDefaults.lastButtonShape(),
                    onClick = { onItemClick.invoke(item) },
                )
            } else {
                SegmentedButton(
                    modifier = Modifier.width(buttonWidth.value),
                    title = item.title,
                    isSelected = item == selectedItem,
                    shape = SegmentedButtonDefaults.centerButtonShape(),
                    onClick = { onItemClick.invoke(item) },
                )
            }
        }
    }
}

@Composable
fun SegmentedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String,
    shape: Shape,
    isSelected: Boolean,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(SegmentedButtonDefaults.height),
        contentPadding = SegmentedButtonDefaults.contentPadding(),
        colors = SegmentedButtonDefaults.buttonColors(isSelected = isSelected),
        shape = shape,
    ) {
        if (isSelected) {
            Icon(
                modifier = Modifier
                    .size(SegmentedButtonDefaults.selectedIconSize)
                    .padding(end = SegmentedButtonDefaults.selectedIconPadding),
                imageVector = Icons.Default.Check,
                contentDescription = "Selected",
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun SegmentedButtonCornerShape(
    cornerStart: Dp = 0.dp,
    cornerEnd: Dp = 0.dp,
) = RoundedCornerShape(
    topStart = cornerStart,
    bottomStart = cornerStart,
    topEnd = cornerEnd,
    bottomEnd = cornerEnd,
)

object SegmentedButtonDefaults {

    val height = 40.dp

    val defualtWidth = 100.dp

    val selectedIconSize = 16.dp

    val selectedIconPadding = 4.dp

    private val horizontalContentPadding = 4.dp

    private val verticalContentPadding = 0.dp

    private val shapeCorner = 100.dp

    @Composable
    fun contentPadding(
        horizontal: Dp = horizontalContentPadding,
        vertical: Dp = verticalContentPadding,
    ) = PaddingValues(horizontal = horizontal, vertical = vertical)

    @Composable
    fun selectedButtonColors(): ButtonColors = ButtonDefaults.filledTonalButtonColors()

    @Composable
    fun defualtButtonColors(): ButtonColors = ButtonDefaults.outlinedButtonColors()

    @Composable
    fun buttonColors(isSelected: Boolean): ButtonColors = if (isSelected) {
        selectedButtonColors()
    } else {
        defualtButtonColors()
    }

    @Composable
    fun firstButtonShape(corner: Dp = shapeCorner): RoundedCornerShape =
        SegmentedButtonCornerShape(cornerStart = corner)

    @Composable
    fun centerButtonShape(corner: Dp = 0.dp): RoundedCornerShape =
        SegmentedButtonCornerShape(cornerStart = corner, cornerEnd = corner)

    @Composable
    fun lastButtonShape(corner: Dp = shapeCorner): RoundedCornerShape =
        SegmentedButtonCornerShape(cornerEnd = corner)
}