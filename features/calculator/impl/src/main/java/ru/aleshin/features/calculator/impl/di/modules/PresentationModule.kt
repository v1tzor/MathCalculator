package ru.aleshin.features.calculator.impl.di.modules

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.calculator.api.CalculatorFeatureStarter
import ru.aleshin.features.calculator.impl.navigations.CalculatorFeatureStarterImpl
import ru.aleshin.features.calculator.impl.navigations.NavigationManager
import ru.aleshin.features.calculator.impl.presentation.ui.CalculatorScreen
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorActor
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorScreenModel
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorStateCommunicator
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorWorkProcessor

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
    fun bindCalculatorActor(actor: CalculatorActor.Base): CalculatorActor

    @Binds
    @FeatureScope
    fun bindCalculatorWorkProcessor(processor: CalculatorWorkProcessor.Base): CalculatorWorkProcessor
}