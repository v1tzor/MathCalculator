package ru.aleshin.features.calculator.api

import ru.aleshin.module_injector.BaseFeatureApi

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CalculatorFeatureApi : BaseFeatureApi {
    fun fetchStarter(): CalculatorFeatureStarter
}