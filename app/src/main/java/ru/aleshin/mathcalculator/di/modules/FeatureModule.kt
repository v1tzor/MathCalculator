package ru.aleshin.mathcalculator.di.modules

import dagger.Module
import dagger.Provides
import ru.aleshin.features.calculator.impl.di.CalculatorFeatureDependencies
import ru.aleshin.features.calculator.impl.di.holder.CalculatorComponentHolder
import ru.aleshin.features.settings.impl.di.SettingsFeatureDependencies
import ru.aleshin.features.settings.impl.di.holder.SettingsComponentHolder

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
class FeatureModule {

    @Provides
    fun provideCalculatorFeatureStarter(
        dependencies: CalculatorFeatureDependencies,
    ) = with(CalculatorComponentHolder) {
        init(dependencies)
        fetchApi().fetchStarter()
    }

    @Provides
    fun provideSettingsFeatureStarter(
        dependencies: SettingsFeatureDependencies,
    ) = with(SettingsComponentHolder) {
        init(dependencies)
        fetchApi().fetchStarter()
    }
}
