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
package ru.aleshin.features.settings.impl.domain.interactors

import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.database.domain.repositories.ThemeSettingsRepository
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.features.settings.impl.domain.common.SettingsEitherWrapper
import ru.aleshin.features.settings.impl.domain.common.SettingsFailures
import ru.aleshin.features.settings.impl.domain.entities.Settings
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsInteractor {

    suspend fun updateThemeSettings(settings: ThemeSettings): Either<SettingsFailures, Unit>

    suspend fun fetchAllSettings(): Either<SettingsFailures, Settings>

    class Base @Inject constructor(
        private val themeSettingsRepository: ThemeSettingsRepository,
        private val eitherWrapper: SettingsEitherWrapper,
    ) : SettingsInteractor {

        override suspend fun updateThemeSettings(settings: ThemeSettings) = eitherWrapper.wrap {
            themeSettingsRepository.updateSettings(settings)
        }

        override suspend fun fetchAllSettings() = eitherWrapper.wrap {
            val themeSettings = themeSettingsRepository.fetchSettings()

            return@wrap Settings(themeSettings = themeSettings)
        }
    }
}