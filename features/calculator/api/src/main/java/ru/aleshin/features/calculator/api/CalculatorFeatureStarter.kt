package ru.aleshin.features.calculator.api

import cafe.adriel.voyager.core.screen.Screen

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CalculatorFeatureStarter {
    fun provideMainScreen(): Screen
}