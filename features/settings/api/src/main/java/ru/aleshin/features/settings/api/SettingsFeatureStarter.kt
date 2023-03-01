package ru.aleshin.features.settings.api

import cafe.adriel.voyager.core.screen.Screen

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SettingsFeatureStarter {
    fun provideMainScreen(): Screen
}