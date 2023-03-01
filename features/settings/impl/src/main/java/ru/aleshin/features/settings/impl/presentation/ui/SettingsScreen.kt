package ru.aleshin.features.settings.impl.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.core.utils.platform.screen.rememberViewState
import ru.aleshin.features.settings.impl.presentation.theme.SettingsTheme
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsEvent
import ru.aleshin.features.settings.impl.presentation.ui.contract.SettingsViewState
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.rememberSettingsScreenModel
import ru.aleshin.features.settings.impl.presentation.ui.views.SettingsTopAppBar
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class SettingsScreen @Inject constructor() : Screen {

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        val screenModel = rememberSettingsScreenModel()
        val state = rememberViewState(screenModel, SettingsViewState())

        SettingsTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                content = {
                    Box(modifier = Modifier.padding(it)) {
                        SettingsContent(
                            state = state,
                            onUpdateThemeSettings = {
                                screenModel.dispatchEvent(SettingsEvent.ChangedThemeSettings(it))
                            },
                        )
                    }
                },
                topBar = {
                    SettingsTopAppBar(
                        onBackButtonClick = {
                            screenModel.dispatchEvent(SettingsEvent.PressBackButton)
                        },
                    )
                },
            )
        }
    }
}