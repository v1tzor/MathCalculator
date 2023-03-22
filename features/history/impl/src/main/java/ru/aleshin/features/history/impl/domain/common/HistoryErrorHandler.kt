package ru.aleshin.features.history.impl.domain.common

import ru.aleshin.core.utils.handlers.ErrorHandler
import ru.aleshin.features.history.impl.domain.entities.HistoryFailures
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
internal interface HistoryErrorHandler : ErrorHandler<HistoryFailures> {
    class Base @Inject constructor() : HistoryErrorHandler {
        override fun handle(throwable: Throwable) = when (throwable) {
            else -> HistoryFailures.OtherError(throwable)
        }
    }
}