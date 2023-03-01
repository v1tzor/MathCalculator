package ru.aleshin.core.database.data.datasources.settings

import kotlinx.coroutines.flow.Flow
import ru.aleshin.core.database.data.models.ThemeSettingsEntity
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface ThemeSettingsLocalDataSource {

    fun fetchSettings(): Flow<ThemeSettingsEntity>

    fun updateSettings(settings: ThemeSettingsEntity)

    class Base @Inject constructor(
        private val settingsDao: ThemeSettingsDao,
    ) : ThemeSettingsLocalDataSource {

        override fun fetchSettings(): Flow<ThemeSettingsEntity> {
            return settingsDao.fetchSettings()
        }

        override fun updateSettings(settings: ThemeSettingsEntity) {
            settingsDao.updateSettings(settings)
        }
    }
}