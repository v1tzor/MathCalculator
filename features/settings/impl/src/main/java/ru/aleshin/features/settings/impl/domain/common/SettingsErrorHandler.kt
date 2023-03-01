package ru.aleshin.features.settings.impl.domain.common

import ru.aleshin.core.utils.handlers.ErrorHandler
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsErrorHandler : ErrorHandler<SettingsFailures> {
    class Base @Inject constructor() : SettingsErrorHandler {
        override fun handle(throwable: Throwable) = when (throwable) {
            else -> SettingsFailures.OtherError(throwable)
        }
    }
}