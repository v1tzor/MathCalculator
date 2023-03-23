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
package ru.aleshin.features.history.impl.di.modules

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.history.api.navigation.HistoryFeatureStarter
import ru.aleshin.features.history.impl.navigation.HistoryFeatureStarterImpl
import ru.aleshin.features.history.impl.navigation.NavigationManager
import ru.aleshin.features.history.impl.presentation.ui.HistoryScreen
import ru.aleshin.features.history.impl.presentation.ui.screenmodel.HistoryEffectCommunicator
import ru.aleshin.features.history.impl.presentation.ui.screenmodel.HistoryScreenModel
import ru.aleshin.features.history.impl.presentation.ui.screenmodel.HistoryStateCommunicator
import ru.aleshin.features.history.impl.presentation.ui.screenmodel.HistoryWorkProcessor

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@Module
internal interface PresentationModule {

    @Binds
    @FeatureScope
    fun bindHistoryFeatureStarter(starter: HistoryFeatureStarterImpl): HistoryFeatureStarter

    @Binds
    @FeatureScope
    fun bindHistoryScreen(screen: HistoryScreen): Screen

    @Binds
    @FeatureScope
    fun bindNavigationManager(manager: NavigationManager.Base): NavigationManager

    @Binds
    fun bindHistoryScreenModel(screenModel: HistoryScreenModel): ScreenModel

    @Binds
    @FeatureScope
    fun bindHistoryStateCommunicator(communicator: HistoryStateCommunicator.Base): HistoryStateCommunicator

    @Binds
    @FeatureScope
    fun bindHistoryEffectCommunicator(communicator: HistoryEffectCommunicator.Base): HistoryEffectCommunicator

    @Binds
    fun bindHistoryWorkProcessor(processor: HistoryWorkProcessor.Base): HistoryWorkProcessor
}