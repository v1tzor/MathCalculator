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
package ru.aleshin.features.calculator.impl.navigations

import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.features.history.api.HistoryFeatureStarter
import ru.aleshin.features.settings.api.SettingsFeatureStarter
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface NavigationManager {

    fun navigateToSettingsFeature()
    fun navigateToHistoryFeature()

    class Base @Inject constructor(
        private val settingsFeatureStarter: Provider<SettingsFeatureStarter>,
        private val historyFeatureStarter: Provider<HistoryFeatureStarter>,
        private val router: Router,
    ) : NavigationManager {

        override fun navigateToSettingsFeature() {
            val screen = settingsFeatureStarter.get().provideMainScreen()
            router.navigateTo(screen)
        }

        override fun navigateToHistoryFeature() {
            val screen = historyFeatureStarter.get().provideMainScreen()
            router.navigateTo(screen)
        }
    }
}