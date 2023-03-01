package ru.aleshin.features.settings.impl.di

import ru.aleshin.core.database.domain.repositories.ThemeSettingsRepository
import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.module_injector.BaseFeatureDependencies

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SettingsFeatureDependencies : BaseFeatureDependencies {
    val themeSettingsRepository: ThemeSettingsRepository
    val coroutineManager: CoroutineManager
    val globalRouter: Router
}