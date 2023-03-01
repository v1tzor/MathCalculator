package ru.aleshin.features.calculator.impl.di.component

import dagger.Component
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.calculator.api.CalculatorFeatureApi
import ru.aleshin.features.calculator.impl.di.CalculatorFeatureDependencies
import ru.aleshin.features.calculator.impl.di.modules.PresentationModule
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorScreenModel

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@FeatureScope
@Component(
    modules = [PresentationModule::class],
    dependencies = [CalculatorFeatureDependencies::class],
)
internal interface CalculatorComponent : CalculatorFeatureApi {

    fun fetchCalculatorScreenModel(): CalculatorScreenModel

    @Component.Builder
    interface Builder {
        fun dependencies(deps: CalculatorFeatureDependencies): Builder
        fun build(): CalculatorComponent
    }

    companion object {
        fun create(dependencies: CalculatorFeatureDependencies): CalculatorComponent {
            return DaggerCalculatorComponent.builder()
                .dependencies(dependencies)
                .build()
        }
    }
}