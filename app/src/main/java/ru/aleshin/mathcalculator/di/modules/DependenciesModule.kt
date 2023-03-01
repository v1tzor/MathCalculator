package ru.aleshin.mathcalculator.di.modules

import dagger.Binds
import dagger.Module
import ru.aleshin.features.calculator.impl.di.CalculatorFeatureDependencies
import ru.aleshin.features.settings.impl.di.SettingsFeatureDependencies
import ru.aleshin.mathcalculator.di.component.AppComponent

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Module
interface DependenciesModule {

    @Binds
    fun bindCalculatorFeatureDependencies(component: AppComponent): CalculatorFeatureDependencies

    @Binds
    fun bindSettingsFeatureDependencies(component: AppComponent): SettingsFeatureDependencies
}
