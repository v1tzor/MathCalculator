package ru.aleshin.features.calculator.impl.navigations

import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.features.calculator.api.CalculatorFeatureStarter
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal class CalculatorFeatureStarterImpl @Inject constructor(
    private val settingsScreen: Screen,
) : CalculatorFeatureStarter {

    override fun provideMainScreen(): Screen = settingsScreen
}