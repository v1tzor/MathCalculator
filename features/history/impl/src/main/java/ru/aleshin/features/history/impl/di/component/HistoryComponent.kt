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
package ru.aleshin.features.history.impl.di.component

import dagger.Component
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.history.api.di.HistoryFeatureApi
import ru.aleshin.features.history.impl.di.HistoryFeatureDependencies
import ru.aleshin.features.history.impl.di.modules.DomainModule
import ru.aleshin.features.history.impl.di.modules.PresentationModule
import ru.aleshin.features.history.impl.presentation.ui.screenmodel.HistoryScreenModel

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@FeatureScope
@Component(
    modules = [DomainModule::class, PresentationModule::class],
    dependencies = [HistoryFeatureDependencies::class],
)
internal interface HistoryComponent : HistoryFeatureApi {

    fun fetchHistoryScreenModel(): HistoryScreenModel

    @Component.Builder
    interface Builder {
        fun dependencies(deps: HistoryFeatureDependencies): Builder
        fun build(): HistoryComponent
    }

    companion object {
        fun create(deps: HistoryFeatureDependencies): HistoryComponent {
            return DaggerHistoryComponent.builder()
                .dependencies(deps)
                .build()
        }
    }
}