package ru.aleshin.mathcalculator.di.modules

import dagger.Binds
import dagger.Module
import ru.aleshin.mathcalculator.domain.common.MainEitherWrapper
import ru.aleshin.mathcalculator.domain.common.MainErrorHandler
import ru.aleshin.mathcalculator.domain.interactors.SettingsInteractor
import javax.inject.Singleton

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
interface DomainModules {

    @Binds
    @Singleton
    fun bindSettingsInteractor(interactor: SettingsInteractor.Base): SettingsInteractor

    @Binds
    fun bindMainEitherWrapper(wrapper: MainEitherWrapper.Base): MainEitherWrapper

    @Binds
    fun bindMainErrorHandler(handler: MainErrorHandler.Base): MainErrorHandler
}