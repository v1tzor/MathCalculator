/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
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
