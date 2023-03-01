package ru.aleshin.mathcalculator.presentation.ui.main

import androidx.compose.runtime.Composable
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.core.utils.navigations.navigator.AppNavigator
import ru.aleshin.core.utils.navigations.navigator.NavigatorManager
import ru.aleshin.core.utils.platform.activity.BaseActivity
import ru.aleshin.core.utils.platform.screen.rememberViewState
import ru.aleshin.mathcalculator.application.fetchApp
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainViewState
import ru.aleshin.mathcalculator.presentation.ui.main.viewmodel.MainViewModel
import ru.aleshin.mathcalculator.presentation.ui.splash.SplashScreen
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var navigatorManager: NavigatorManager

    @Inject
    lateinit var viewModelFactory: MainViewModel.Factory

    override fun initDI() = fetchApp().appComponent.inject(this)

    @Composable
    override fun Content() {
        val state = rememberViewState(viewModel, MainViewState())

        MathCalculatorTheme(
            themeColorsType = state.colors,
            language = state.language,
        ) {
            AppNavigator(initialScreen = SplashScreen(), navigatorManager = navigatorManager)
        }
    }

    override fun fetchViewModelFactory() = viewModelFactory

    override fun fetchViewModelClass() = MainViewModel::class.java
}
