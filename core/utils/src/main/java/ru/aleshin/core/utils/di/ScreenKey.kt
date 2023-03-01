package ru.aleshin.core.utils.di

import cafe.adriel.voyager.core.screen.Screen
import javax.inject.Qualifier
import kotlin.reflect.KClass

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Qualifier
annotation class ScreenKey(val screen: KClass<out Screen>)
