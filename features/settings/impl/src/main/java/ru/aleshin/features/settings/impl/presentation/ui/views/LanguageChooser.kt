package ru.aleshin.features.settings.impl.presentation.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.aleshin.features.settings.api.domain.entities.LanguageType
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.features.settings.impl.presentation.mappers.toLanguageName
import ru.aleshin.features.settings.impl.presentation.theme.SettingsThemeRes

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageChooser(
    language: LanguageType,
    onLanguageChanged: (LanguageType) -> Unit,
) {
    val isOpenDialog = rememberSaveable { mutableStateOf(false) }
    Surface(
        modifier = Modifier.height(56.dp),
        onClick = { isOpenDialog.value = true },
        shape = MaterialTheme.shapes.medium,
        tonalElevation = MathCalculatorRes.elevations.levelTwo,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = SettingsThemeRes.strings.mainSettingsLanguageTitle,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                modifier = Modifier.weight(1f),
                text = language.toLanguageName(),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
    LanguageDialogChooser(
        openDialog = isOpenDialog.value,
        initialLanguage = language,
        onLanguageChoose = { languageType ->
            isOpenDialog.value = false
            onLanguageChanged(languageType)
        },
        onCloseDialog = { isOpenDialog.value = false },
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LanguageDialogChooser(
    modifier: Modifier = Modifier,
    openDialog: Boolean,
    initialLanguage: LanguageType,
    onLanguageChoose: (LanguageType) -> Unit,
    onCloseDialog: () -> Unit,
) {
    if (openDialog) {
        val initPosition = LanguageType.values().indexOf(initialLanguage)
        val listState = rememberLazyListState(initPosition)
        val selectedLanguage = rememberSaveable { mutableStateOf(initialLanguage) }
        AlertDialog(onDismissRequest = onCloseDialog) {
            Surface(
                modifier = modifier
                    .width(280.dp)
                    .wrapContentHeight(),
                tonalElevation = MathCalculatorRes.elevations.levelThree,
                shape = MaterialTheme.shapes.extraLarge,
            ) {
                Column {
                    Box(
                        modifier = Modifier.padding(
                            start = 24.dp,
                            end = 24.dp,
                            top = 24.dp,
                            bottom = 12.dp,
                        ),
                    ) {
                        Text(
                            text = SettingsThemeRes.strings.mainSettingsLanguageTitle,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                    LazyColumn(modifier = Modifier.height(300.dp), state = listState) {
                        items(LanguageType.values()) { language ->
                            LanguageDialogItem(
                                modifier = Modifier.fillMaxWidth(),
                                title = language.toLanguageName(),
                                selected = selectedLanguage.value == language,
                                onSelectChange = { selectedLanguage.value = language },
                            )
                        }
                    }
                    DialogButtons(
                        onCancelClick = onCloseDialog,
                        onConfirmClick = { onLanguageChoose.invoke(selectedLanguage.value) },
                    )
                }
            }
        }
    }
}

@Composable
internal fun LanguageDialogItem(
    modifier: Modifier = Modifier,
    title: String,
    selected: Boolean,
    onSelectChange: () -> Unit,
) {
    Column {
        Row(
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 8.dp)
                .clip(MaterialTheme.shapes.medium)
                .clickable(onClick = onSelectChange)
                .padding(start = 8.dp, end = 16.dp)
                .requiredHeight(56.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp).weight(1f),
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
            RadioButton(selected = selected, onClick = null)
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
    }
}

@Composable
internal fun DialogButtons(
    onCancelClick: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    Row(
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 16.dp,
            end = 16.dp,
            start = 8.dp,
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = onCancelClick) {
            Text(
                text = MathCalculatorRes.strings.alertDialogDismissTitle,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        }
        TextButton(onClick = onConfirmClick) {
            Text(
                text = MathCalculatorRes.strings.alertDialogConfirmTitle,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}