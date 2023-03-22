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
package ru.aleshin.features.calculator.impl.di.modules

import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.calculator.impl.domain.common.CalculatorEitherWrapper
import ru.aleshin.features.calculator.impl.domain.common.CalculatorErrorHandler
import ru.aleshin.features.calculator.impl.domain.interactors.CalculatorInteractor
import ru.aleshin.features.calculator.impl.domain.interactors.HistoryInteractor

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
@Module
internal interface DomainModule {

    @Binds
    @FeatureScope
    fun bindCalculatorInteractor(interactor: CalculatorInteractor.Base): CalculatorInteractor

    @Binds
    @FeatureScope
    fun bindHistoryInteractor(interactor: HistoryInteractor.Base): HistoryInteractor

    @Binds
    fun bindCalculatorEitherWrapper(wrapper: CalculatorEitherWrapper.Base): CalculatorEitherWrapper

    @Binds
    fun bindCalculatorErrorHandler(handler: CalculatorErrorHandler.Base): CalculatorErrorHandler
}