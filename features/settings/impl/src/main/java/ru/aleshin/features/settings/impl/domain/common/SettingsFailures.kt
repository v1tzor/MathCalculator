package ru.aleshin.features.settings.impl.domain.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.functional.DomainFailures

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
internal sealed class SettingsFailures : DomainFailures, Parcelable {
    data class OtherError(val throwable: Throwable) : SettingsFailures()
}