package ru.aleshin.mathcalculator.presentation.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ru.aleshin.mathcalculator.presentation.theme.MainTheme
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEvent
import ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel.rememberSplashScreenModel

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberSplashScreenModel()
        MainTheme {
            Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                SplashContent(onSplashExit = { screenModel.dispatchEvent(SplashEvent.AfterSplash) })
            }
        }
    }
}
