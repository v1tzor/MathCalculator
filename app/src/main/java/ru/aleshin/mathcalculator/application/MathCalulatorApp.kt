package ru.aleshin.mathcalculator.application

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ru.aleshin.mathcalculator.di.component.AppComponent

/**
 * @author Stanislav Aleshin on 14.02.2023.
 */
class MathCalculatorApp : Application() {

    val appComponent by lazy {
        AppComponent.create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }
}

fun Context.fetchApp(): MathCalculatorApp {
    return applicationContext as MathCalculatorApp
}

@Composable
fun fetchAppComponent(): AppComponent {
    val context = LocalContext.current

    return context.fetchApp().appComponent
}
