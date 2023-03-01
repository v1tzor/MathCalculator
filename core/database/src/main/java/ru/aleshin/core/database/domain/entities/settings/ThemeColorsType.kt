package ru.aleshin.core.database.domain.entities.settings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
enum class ThemeColorsType : Parcelable {
    DEFUALT, LIGHT, DARK
}