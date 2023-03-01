package ru.aleshin.features.calculator.impl.di.holder

import ru.aleshin.features.calculator.api.CalculatorFeatureApi
import ru.aleshin.features.calculator.impl.di.CalculatorFeatureDependencies
import ru.aleshin.features.calculator.impl.di.component.CalculatorComponent
import ru.aleshin.module_injector.BaseComponentHolder

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
object CalculatorComponentHolder : BaseComponentHolder<CalculatorFeatureApi, CalculatorFeatureDependencies> {

    private var component: CalculatorComponent? = null

    override fun init(dependencies: CalculatorFeatureDependencies) {
        if (component == null) {
            component = CalculatorComponent.create(dependencies)
        }
    }

    internal fun fetchComponent() = checkNotNull(component) {
        "Calculator Component is not initializing"
    }

    override fun fetchApi(): CalculatorFeatureApi = fetchComponent()

    override fun clear() {
        component = null
    }
}