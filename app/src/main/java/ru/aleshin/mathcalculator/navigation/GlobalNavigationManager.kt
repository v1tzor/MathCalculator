package ru.aleshin.mathcalculator.navigation

import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.features.calculator.api.CalculatorFeatureStarter
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Stanislav Aleshin on 14.02.2023.
 */
interface GlobalNavigationManager {

    fun navigateToCalculatorFeature()

    class Base @Inject constructor(
        private val router: Router,
        private val calculatorFeatureStarter: Provider<CalculatorFeatureStarter>,
    ) : GlobalNavigationManager {

        override fun navigateToCalculatorFeature() {
            val screen = calculatorFeatureStarter.get().provideMainScreen()
            router.replaceTo(screen)
        }
    }
}
