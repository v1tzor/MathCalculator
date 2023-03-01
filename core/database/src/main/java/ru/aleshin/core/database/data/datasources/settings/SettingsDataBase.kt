package ru.aleshin.core.database.data.datasources.settings

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.aleshin.core.database.data.models.ThemeSettingsEntity

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Database(entities = [ThemeSettingsEntity::class], version = 1)
abstract class SettingsDataBase : RoomDatabase() {

    abstract fun fetchThemeSettingsDao(): ThemeSettingsDao

    companion object {
        const val NAME = "CalculatorSettingsDataBase.db"
    }
}