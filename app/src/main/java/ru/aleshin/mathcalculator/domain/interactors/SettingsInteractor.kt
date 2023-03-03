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
package ru.aleshin.mathcalculator.domain.interactors

import kotlinx.coroutines.flow.Flow
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.database.domain.repositories.ThemeSettingsRepository
import ru.aleshin.core.utils.functional.Either
import ru.aleshin.mathcalculator.domain.common.MainEitherWrapper
import ru.aleshin.mathcalculator.domain.common.MainFailures
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SettingsInteractor {

    suspend fun fetchThemeSettings(): Flow<Either<MainFailures, ThemeSettings>>

    class Base @Inject constructor(
        private val settingsRepository: ThemeSettingsRepository,
        private val eitherWrapper: MainEitherWrapper,
    ) : SettingsInteractor {

        override suspend fun fetchThemeSettings() = eitherWrapper.wrapFlow {
            settingsRepository.fetchSettingsFlow()
        }
    }
}