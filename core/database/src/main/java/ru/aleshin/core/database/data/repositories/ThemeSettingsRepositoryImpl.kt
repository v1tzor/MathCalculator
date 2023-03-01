package ru.aleshin.core.database.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import ru.aleshin.core.database.data.datasources.settings.ThemeSettingsLocalDataSource
import ru.aleshin.core.database.data.models.ThemeSettingsEntity
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.database.domain.repositories.ThemeSettingsRepository
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
class ThemeSettingsRepositoryImpl @Inject constructor(
    private val localDataSource: ThemeSettingsLocalDataSource,
) : ThemeSettingsRepository {

    override suspend fun fetchSettingsFlow(): Flow<ThemeSettings> {
        return localDataSource.fetchSettings().map { it.settings }
    }

    override suspend fun fetchSettings(): ThemeSettings {
        val dataModel = localDataSource.fetchSettings().first()
        return dataModel.settings
    }

    override suspend fun updateSettings(settings: ThemeSettings) {
        localDataSource.updateSettings(ThemeSettingsEntity(settings = settings))
    }
}