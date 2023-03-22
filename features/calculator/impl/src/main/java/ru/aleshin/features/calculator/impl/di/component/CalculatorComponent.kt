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
package ru.aleshin.features.calculator.impl.di.component

import dagger.Component
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.calculator.api.CalculatorFeatureApi
import ru.aleshin.features.calculator.impl.di.CalculatorFeatureDependencies
import ru.aleshin.features.calculator.impl.di.modules.DataModule
import ru.aleshin.features.calculator.impl.di.modules.DomainModule
import ru.aleshin.features.calculator.impl.di.modules.PresentationModule
import ru.aleshin.features.calculator.impl.presentation.ui.screenmodel.CalculatorScreenModel

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@FeatureScope
@Component(
    modules = [DataModule::class, DomainModule::class, PresentationModule::class],
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