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

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.aleshin.core.database.data.datasources.settings.SettingsDataBase
import ru.aleshin.core.database.data.datasources.settings.ThemeSettingsDao
import ru.aleshin.core.database.data.datasources.settings.ThemeSettingsLocalDataSource
import ru.aleshin.core.database.data.repositories.ThemeSettingsRepositoryImpl
import ru.aleshin.core.database.domain.repositories.ThemeSettingsRepository
import ru.aleshin.core.utils.di.ApplicationContext
import javax.inject.Singleton

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideThemeSettingsRepositoryImpl(
        localDataSource: ThemeSettingsLocalDataSource,
    ): ThemeSettingsRepository = ThemeSettingsRepositoryImpl(localDataSource)

    @Provides
    @Singleton
    fun provideThemeSettingsLocalDataSource(
        dao: ThemeSettingsDao,
    ): ThemeSettingsLocalDataSource = ThemeSettingsLocalDataSource.Base(dao)

    @Provides
    @Singleton
    fun provideThemeSettingsDao(
        dataBase: SettingsDataBase,
    ): ThemeSettingsDao = dataBase.fetchThemeSettingsDao()

    @Provides
    @Singleton
    fun provideSettingsDataBase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context = context,
        klass = SettingsDataBase::class.java,
        name = SettingsDataBase.NAME,
    ).createFromAsset("database/settings_prepopulated.db").build()
}
