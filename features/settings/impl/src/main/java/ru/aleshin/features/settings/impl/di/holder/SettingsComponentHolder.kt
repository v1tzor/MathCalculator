package ru.aleshin.features.settings.impl.di.holder

import ru.aleshin.features.settings.api.SettingsFeatureApi
import ru.aleshin.features.settings.impl.di.SettingsFeatureDependencies
import ru.aleshin.features.settings.impl.di.component.SettingsComponent
import ru.aleshin.module_injector.BaseComponentHolder

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
object SettingsComponentHolder :
    BaseComponentHolder<SettingsFeatureApi, SettingsFeatureDependencies> {

    private var component: SettingsComponent? = null

    override fun init(dependencies: SettingsFeatureDependencies) {
        if (component == null) {
            component = SettingsComponent.create(dependencies)
        }
    }

    internal fun fetchComponent() = checkNotNull(component) {
        "Settings Component is not initializing"
    }

    override fun fetchApi(): SettingsFeatureApi = fetchComponent()

    override fun clear() {
        component = null
    }
}