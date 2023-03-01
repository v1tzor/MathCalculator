package ru.aleshin.mathcalculator.di.modules

import dagger.Module
import dagger.Provides
import ru.aleshin.core.utils.navigations.CommandBuffer
import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.core.utils.navigations.navigator.NavigatorManager
import javax.inject.Singleton

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideGlobalNavigatorManager(
        commandBuffer: CommandBuffer,
    ): NavigatorManager = NavigatorManager.Base(commandBuffer)

    @Provides
    @Singleton
    fun provideGlobalCommandBuffer(): CommandBuffer = CommandBuffer.Base()

    @Provides
    @Singleton
    fun provideGlobalRouter(commandBuffer: CommandBuffer): Router = Router.Base(commandBuffer)
}
