package ru.aleshin.features.settings.api

import ru.aleshin.module_injector.BaseFeatureApi

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SettingsFeatureApi : BaseFeatureApi {
    fun fetchStarter(): SettingsFeatureStarter
}