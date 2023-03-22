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
import ru.aleshin.features.calculator.impl.data.datasource.CalculatorLocalDataSource
import ru.aleshin.features.calculator.impl.data.repositories.CalculatorRepositoryImpl
import ru.aleshin.features.calculator.impl.domain.repositories.CalculatorRepository

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
@Module
internal interface DataModule {

    @Binds
    @FeatureScope
    fun bindCalculatorRepository(repository: CalculatorRepositoryImpl): CalculatorRepository

    @Binds
    @FeatureScope
    fun bindCalculatorLocalDataSource(dataSource: CalculatorLocalDataSource.Base): CalculatorLocalDataSource
}