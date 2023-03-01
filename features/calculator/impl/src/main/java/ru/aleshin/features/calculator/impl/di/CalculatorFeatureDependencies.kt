package ru.aleshin.features.calculator.impl.di

import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.managers.MathManager
import ru.aleshin.core.utils.navigations.Router
import ru.aleshin.features.settings.api.SettingsFeatureStarter
import ru.aleshin.module_injector.BaseFeatureDependencies

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface CalculatorFeatureDependencies : BaseFeatureDependencies {
    val globalRouter: Router
    val coroutineManager: CoroutineManager
    val mathManager: MathManager
    val settingsFeatureStarter: SettingsFeatureStarter
}