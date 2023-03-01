package ru.aleshin.mathcalculator.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cafe.adriel.voyager.core.model.ScreenModel
import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.ScreenModelKey
import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.managers.MathManager
import ru.aleshin.mathcalculator.presentation.ui.main.viewmodel.MainActor
import ru.aleshin.mathcalculator.presentation.ui.main.viewmodel.MainStateCommunicator
import ru.aleshin.mathcalculator.presentation.ui.main.viewmodel.MainViewModel
import ru.aleshin.mathcalculator.presentation.ui.main.viewmodel.SettingsWorkProcessor
import ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel.SplashActor
import ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel.SplashScreenModel
import ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel.SplashStateCommunicator
import javax.inject.Singleton

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
interface PresentationModule {

    // Core

    @Binds
    @Singleton
    fun bindCoroutineManager(manager: CoroutineManager.Base): CoroutineManager

    @Binds
    @Singleton
    fun bindMathManager(manager: MathManager.Base): MathManager

    @Binds
    @Singleton
    fun bindAppNavigationManager(manager: ru.aleshin.mathcalculator.navigation.GlobalNavigationManager.Base): ru.aleshin.mathcalculator.navigation.GlobalNavigationManager

    // Main ViewModel

    @Binds
    fun bindMainViewModelFactory(factory: MainViewModel.Factory): ViewModelProvider.Factory

    @Binds
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @Singleton
    fun bindMainStateCommunicator(communicator: MainStateCommunicator.Base): MainStateCommunicator

    @Binds
    fun bindMainActor(actor: MainActor.Base): MainActor

    @Binds
    fun bindSettingsWorkProcessor(processor: SettingsWorkProcessor.Base): SettingsWorkProcessor

    // Splash ScreenModel

    @Binds
    @ScreenModelKey(SplashScreenModel::class)
    fun bindSplashScreenModel(screenModel: SplashScreenModel): ScreenModel

    @Binds
    @Singleton
    fun bindSplashStateCommunicator(communicator: SplashStateCommunicator.Base): SplashStateCommunicator

    @Binds
    fun bindSplashActor(actor: SplashActor.Base): SplashActor
}
