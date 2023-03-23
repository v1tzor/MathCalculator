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
package ru.aleshin.features.settings.api.data.datasource

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface ThemeSettingsLocalDataSource {

    fun fetchSettings(): Flow<ru.aleshin.features.settings.api.data.models.ThemeSettingsEntity>

    fun updateSettings(settings: ru.aleshin.features.settings.api.data.models.ThemeSettingsEntity)

    class Base @Inject constructor(
        private val settingsDao: ru.aleshin.features.settings.api.data.datasource.ThemeSettingsDao,
    ) : ThemeSettingsLocalDataSource {

        override fun fetchSettings(): Flow<ru.aleshin.features.settings.api.data.models.ThemeSettingsEntity> {
            return settingsDao.fetchSettings()
        }

        override fun updateSettings(settings: ru.aleshin.features.settings.api.data.models.ThemeSettingsEntity) {
            settingsDao.updateSettings(settings)
        }
    }
}