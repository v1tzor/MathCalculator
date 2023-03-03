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

import androidx.compose.foundation.Image // ktlint-disable import-ordering
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
// import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.mathcalculator.presentation.theme.MainThemeRes

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
fun SplashContent(
    onSplashExit: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.size(MainThemeRes.dimens.launcherIcon),
            painter = painterResource(id = MainThemeRes.icons.launcher),
            contentDescription = MainThemeRes.strings.launcherIconDesc,
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MainThemeRes.dimens.authorTitlePadding),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Text(
            text = MainThemeRes.strings.authorTitle,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surfaceVariant,
        )
    }

    LaunchedEffect(key1 = Unit) {
        delay(1500L)
        onSplashExit.invoke()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashContent_Preview() {
    MathCalculatorTheme {
        SplashContent(onSplashExit = {})
    }
}