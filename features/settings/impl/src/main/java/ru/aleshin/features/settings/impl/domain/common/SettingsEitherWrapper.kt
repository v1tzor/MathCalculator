package ru.aleshin.features.settings.impl.domain.common

import ru.aleshin.core.utils.wrappers.EitherWrapper
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface SettingsEitherWrapper : EitherWrapper<SettingsFailures> {

    class Base @Inject constructor(errorHandler: SettingsErrorHandler) : SettingsEitherWrapper,
        EitherWrapper.Abstract<SettingsFailures>(errorHandler)
}