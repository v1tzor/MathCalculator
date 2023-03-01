package ru.aleshin.features.calculator.impl.navigations

import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.features.settings.api.SettingsFeatureStarter
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface NavigationManager {

    fun navigateToBack()

    fun navigateToSettingsFeature()

    class Base @Inject constructor(
        private val settingsFeatureStarter: Provider<SettingsFeatureStarter>,
        private val router: Router,
    ) : NavigationManager {

        override fun navigateToBack() {
            router.navigateBack()
        }

        override fun navigateToSettingsFeature() {
            val screen = settingsFeatureStarter.get().provideMainScreen()
            router.navigateTo(screen)
        }
    }
}