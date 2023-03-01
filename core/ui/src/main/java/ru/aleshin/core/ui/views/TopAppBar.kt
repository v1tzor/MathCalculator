package ru.aleshin.core.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
fun TopAppBarTitle(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    text: String,
    subText: String? = null,
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            textAlign = textAlign,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
        )
        if (subText != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                textAlign = textAlign,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}

@Composable
fun TopAppBarButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    imageDescription: String,
    onButtonClick: () -> Unit,
) {
    IconButton(
        modifier = modifier.size(48.dp),
        onClick = onButtonClick,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = imageDescription,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
fun TopAppBarButton(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    imageDescription: String,
    onButtonClick: () -> Unit,
) {
    IconButton(
        modifier = modifier.size(48.dp),
        onClick = onButtonClick,
    ) {
        Icon(
            painter = imagePainter,
            contentDescription = imageDescription,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
fun <T : TopAppBarAction> TopAppBarMoreActions(
    modifier: Modifier = Modifier,
    items: Array<T>,
    onItemClick: (T) -> Unit,
    moreIconDescription: String,
) {
    val expanded = rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = modifier.wrapContentSize(Alignment.TopEnd),
    ) {
        IconButton(onClick = { expanded.value = true }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = moreIconDescription,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        DropdownMenu(
            expanded = expanded.value,
            offset = DpOffset(0.dp, 10.dp),
            onDismissRequest = { expanded.value = false },
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            modifier = Modifier.defaultMinSize(minWidth = 200.dp),
                            text = item.title,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    },
                    onClick = {
                        expanded.value = false
                        onItemClick.invoke(item)
                    },
                )
            }
        }
    }
}