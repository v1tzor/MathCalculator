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
package ru.aleshin.features.calculator.impl.di

import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.managers.DateManager
import ru.aleshin.core.utils.managers.MathManager
import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.features.history.api.navigation.HistoryFeatureStarter
import ru.aleshin.features.history.api.domain.repositories.CalculatorHistoryRepository
import ru.aleshin.features.settings.api.navigation.SettingsFeatureStarter
import ru.aleshin.module_injector.BaseFeatureDependencies

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CalculatorFeatureDependencies : BaseFeatureDependencies {
    val globalRouter: Router
    val coroutineManager: CoroutineManager
    val settingsFeatureStarter: SettingsFeatureStarter
    val historyFeatureStarter: HistoryFeatureStarter
    val calculatorHistoryRepository: CalculatorHistoryRepository
    val mathManager: MathManager
    val dateManager: DateManager
}