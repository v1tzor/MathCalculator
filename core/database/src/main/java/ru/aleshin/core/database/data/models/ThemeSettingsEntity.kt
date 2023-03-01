package ru.aleshin.core.database.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Entity(tableName = "ThemeSettings")
data class ThemeSettingsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val settings: ThemeSettings,
)