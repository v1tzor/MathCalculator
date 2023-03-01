package ru.aleshin.mathcalculator.domain.common

import ru.aleshin.core.utils.functional.DomainFailures

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
sealed class MainFailures : DomainFailures {
    data class OtherError(val throwable: Throwable) : MainFailures()
}
