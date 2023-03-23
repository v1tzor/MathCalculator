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
package ru.aleshin.features.calculator.impl.di.holder

import ru.aleshin.features.calculator.api.di.CalculatorFeatureApi
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