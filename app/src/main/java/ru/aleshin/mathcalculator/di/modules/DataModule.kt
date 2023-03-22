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
package ru.aleshin.mathcalculator.di.modules

import dagger.Binds
import dagger.Module
import ru.aleshin.core.database.data.repositories.ThemeSettingsRepositoryImpl
import ru.aleshin.core.database.domain.repositories.ThemeSettingsRepository
import ru.aleshin.features.history.api.data.mappers.CalculatorHistoryDataToDomainMapper
import ru.aleshin.features.history.api.data.mappers.CalculatorHistoryDomainToDataMapper
import ru.aleshin.features.history.api.data.repositories.CalculatorHistoryRepositoryImpl
import ru.aleshin.features.history.api.domain.repositories.CalculatorHistoryRepository
import javax.inject.Singleton

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
@Module
interface DataModule {

    @Binds
    @Singleton
    fun provideThemeSettingsRepository(repository: ThemeSettingsRepositoryImpl): ThemeSettingsRepository

    @Binds
    @Singleton
    fun provideCalculatorHistoryRepository(repository: CalculatorHistoryRepositoryImpl): CalculatorHistoryRepository

    @Binds
    fun provideHistoryDataToDomainMapper(mapper: CalculatorHistoryDataToDomainMapper.Base): CalculatorHistoryDataToDomainMapper

    @Binds
    fun provideHistoryDomainToDataMapper(mapper: CalculatorHistoryDomainToDataMapper.Base): CalculatorHistoryDomainToDataMapper
}