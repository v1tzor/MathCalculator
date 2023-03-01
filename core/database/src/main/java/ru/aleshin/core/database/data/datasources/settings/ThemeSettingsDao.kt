package ru.aleshin.core.database.data.datasources.settings

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.aleshin.core.database.data.models.ThemeSettingsEntity

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Dao
interface ThemeSettingsDao {

    @Query("SELECT * FROM ThemeSettings WHERE id = 0")
    fun fetchSettings(): Flow<ThemeSettingsEntity>

    @Update
    fun updateSettings(entity: ThemeSettingsEntity)
}