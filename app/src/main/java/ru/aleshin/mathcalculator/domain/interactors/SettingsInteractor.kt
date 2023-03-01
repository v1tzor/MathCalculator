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