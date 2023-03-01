package ru.aleshin.mathcalculator.domain.common

import ru.aleshin.core.utils.wrappers.FlowEitherWrapper
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface MainEitherWrapper : FlowEitherWrapper<MainFailures> {

    class Base @Inject constructor(errorHandler: MainErrorHandler) : MainEitherWrapper,
        FlowEitherWrapper.Abstract<MainFailures>(errorHandler)
}