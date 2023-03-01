package ru.aleshin.features.settings.impl.di.component

import dagger.Component
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.features.settings.api.SettingsFeatureApi
import ru.aleshin.features.settings.impl.di.SettingsFeatureDependencies
import ru.aleshin.features.settings.impl.di.modules.DomainModule
import ru.aleshin.features.settings.impl.di.modules.PresentationModule
import ru.aleshin.features.settings.impl.presentation.ui.screensmodel.SettingsScreenModel

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@FeatureScope
@Component(
    modules = [PresentationModule::class, DomainModule::class],
    dependencies = [SettingsFeatureDependencies::class],
)
internal interface SettingsComponent : SettingsFeatureApi {

    fun fetchSettingsScreenModel(): SettingsScreenModel

    @Component.Builder
    interface Builder {
        fun dependencies(deps: SettingsFeatureDependencies): Builder
        fun build(): SettingsComponent
    }

    companion object {
        fun create(dependencies: SettingsFeatureDependencies): SettingsComponent {
            return DaggerSettingsComponent.builder()
                .dependencies(dependencies)
                .build()
        }
    }
}