package ru.aleshin.core.database.domain.entities.settings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.functional.Mapper

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
data class ThemeSettings(
    val language: LanguageType,
    val themeColors: ThemeColorsType
) : Parcelable {
    fun <O> map(mapper: Mapper<ThemeSettings, O>) = mapper.map(this)
}
