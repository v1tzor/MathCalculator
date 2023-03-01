package ru.aleshin.core.database.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface ThemeSettingsRepository {
    suspend fun fetchSettingsFlow(): Flow<ThemeSettings>
    suspend fun fetchSettings(): ThemeSettings
    suspend fun updateSettings(settings: ThemeSettings)
}