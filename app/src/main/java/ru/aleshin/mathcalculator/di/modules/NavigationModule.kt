/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
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
