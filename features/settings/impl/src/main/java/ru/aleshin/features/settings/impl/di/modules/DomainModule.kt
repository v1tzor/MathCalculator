package ru.aleshin.features.settings.impl.di.modules

import dagger.Binds
import dagger.Module
import ru.aleshin.features.settings.impl.domain.common.SettingsEitherWrapper
import ru.aleshin.features.settings.impl.domain.common.SettingsErrorHandler
import ru.aleshin.features.settings.impl.domain.interactors.SettingsInteractor

/**
 * @author Stanislav Aleshin on 17.02.2023.
 */
@Module
internal interface DomainModule {

    @Binds
    fun bindSettingsInteractor(interactor: SettingsInteractor.Base): SettingsInteractor

    @Binds
    fun bindSettingsEitherWrapper(wrapper: SettingsEitherWrapper.Base): SettingsEitherWrapper

    @Binds
    fun bindSettingsErrorHandler(handler: SettingsErrorHandler.Base): SettingsErrorHandler
}