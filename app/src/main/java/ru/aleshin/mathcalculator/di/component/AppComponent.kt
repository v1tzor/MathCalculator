package ru.aleshin.mathcalculator.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.aleshin.core.utils.di.ApplicationContext
import ru.aleshin.core.utils.navigations.navigator.NavigatorManager
import ru.aleshin.features.calculator.impl.di.CalculatorFeatureDependencies
import ru.aleshin.features.settings.impl.di.SettingsFeatureDependencies
import ru.aleshin.mathcalculator.di.modules.*
import ru.aleshin.mathcalculator.presentation.ui.main.MainActivity
import ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel.SplashScreenModel
import javax.inject.Singleton

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Singleton
@Component(
    modules = [
        DataBaseModule::class,
        NavigationModule::class,
        PresentationModule::class,
        DomainModules::class,
        DependenciesModule::class,
        FeatureModule::class,
    ],
)
interface AppComponent : SettingsFeatureDependencies, CalculatorFeatureDependencies {

    fun inject(activity: MainActivity)
    fun fetchSplashScreenModel(): SplashScreenModel
    fun fetchNavigatorManager(): NavigatorManager

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder
        fun navigationModule(module: NavigationModule): Builder
        fun featureModule(module: FeatureModule): Builder
        fun dataBaseModule(module: DataBaseModule): Builder
        fun build(): AppComponent
    }

    companion object {
        fun create(context: Context): AppComponent {
            return DaggerAppComponent.builder()
                .applicationContext(context)
                .navigationModule(NavigationModule())
                .featureModule(FeatureModule())
                .dataBaseModule(DataBaseModule())
                .build()
        }
    }
}
