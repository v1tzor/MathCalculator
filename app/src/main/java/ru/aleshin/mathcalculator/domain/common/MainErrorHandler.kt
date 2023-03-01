package ru.aleshin.mathcalculator.domain.common

import ru.aleshin.core.utils.handlers.ErrorHandler
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface MainErrorHandler : ErrorHandler<MainFailures> {

    class Base @Inject constructor() : MainErrorHandler {
        override fun handle(throwable: Throwable) = when (throwable) {
            else -> MainFailures.OtherError(throwable)
        }
    }
}