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
package ru.aleshin.features.calculator.impl.di.modules

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.calculator.api.navigation.CalculatorFeatureStarter
import ru.aleshin.features.calculator.impl.navigations.CalculatorFeatureStarterImpl
import ru.aleshin.features.calculator.impl.navigations.NavigationManager
import ru.aleshin.features.calculator.impl.presentation.ui.CalculatorScreen
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorEffectCommunicator
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorScreenModel
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorStateCommunicator
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorWorkProcessor
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.HistoryWorkProcessor

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
internal interface PresentationModule {

    @Binds
    @FeatureScope
    fun bindCalculatorFeatureStarter(starter: CalculatorFeatureStarterImpl): CalculatorFeatureStarter

    @Binds
    @FeatureScope
    fun bindNavigationManager(manager: NavigationManager.Base): NavigationManager

    @Binds
    @FeatureScope
    fun bindCalculatorScreen(screen: CalculatorScreen): Screen

    @Binds
    fun bindCalculatorScreenModel(screenModel: CalculatorScreenModel): ScreenModel

    @Binds
    @FeatureScope
    fun bindCalculatorStateCommunicator(communicator: CalculatorStateCommunicator.Base): CalculatorStateCommunicator

    @Binds
    @FeatureScope
    fun bindCalculatorEffectCommunicator(communicator: CalculatorEffectCommunicator.Base): CalculatorEffectCommunicator

    @Binds
    @FeatureScope
    fun bindCalculatorWorkProcessor(processor: CalculatorWorkProcessor.Base): CalculatorWorkProcessor

    @Binds
    @FeatureScope
    fun bindHistoryWorkProcessor(processor: HistoryWorkProcessor.Base): HistoryWorkProcessor
}