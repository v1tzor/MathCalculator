package ru.aleshin.core.utils.di

import cafe.adriel.voyager.core.model.ScreenModel
import javax.inject.Qualifier
import kotlin.reflect.KClass

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Qualifier
annotation class ScreenModelKey(val screenModel: KClass<out ScreenModel>)
