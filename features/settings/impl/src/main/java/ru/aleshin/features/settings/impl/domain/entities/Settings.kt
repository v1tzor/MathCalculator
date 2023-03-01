package ru.aleshin.features.settings.impl.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.aleshin.core.database.domain.entities.settings.ThemeSettings
import ru.aleshin.core.utils.functional.Mapper

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
internal data class Settings(
    val themeSettings: ThemeSettings,
) : Parcelable {
    fun <T> map(mapper: Mapper<Settings, T>) = mapper.map(this)
}