package ru.aleshin.features.settings.impl.navigations

import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.features.settings.api.SettingsFeatureStarter
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class SettingsFeatureStarterImpl @Inject constructor(
    private val settingsScreen: Screen,
) : SettingsFeatureStarter {

    override fun provideMainScreen(): Screen = settingsScreen
}