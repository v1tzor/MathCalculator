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
package ru.aleshin.features.settings.impl.di.modules

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.settings.api.SettingsFeatureStarter
import ru.aleshin.features.settings.impl.navigations.NavigationManager
import ru.aleshin.features.settings.impl.navigations.SettingsFeatureStarterImpl
import ru.aleshin.features.settings.impl.presentation.ui.SettingsScreen
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.SettingsActor
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.SettingsScreenModel
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.SettingsStateCommunicator
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.SettingsWorkProcessor

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
internal interface PresentationModule {

    @Binds
    @FeatureScope
    fun bindSettingsFeatureStarter(starter: SettingsFeatureStarterImpl): SettingsFeatureStarter

    @Binds
    @FeatureScope
    fun bindNavigationManager(manager: NavigationManager.Base): NavigationManager

    @Binds
    @FeatureScope
    fun bindSettingsScreen(screen: SettingsScreen): Screen

    @Binds
    fun bindSettingsScreenModel(screenModel: SettingsScreenModel): ScreenModel

    @Binds
    @FeatureScope
    fun bindSettingsStateCommunicator(communicator: SettingsStateCommunicator.Base): SettingsStateCommunicator

    @Binds
    fun bindSettingsActor(actor: SettingsActor.Base): SettingsActor

    @Binds
    fun bindSettingsWorkProcessor(processor: SettingsWorkProcessor.Base): SettingsWorkProcessor
}