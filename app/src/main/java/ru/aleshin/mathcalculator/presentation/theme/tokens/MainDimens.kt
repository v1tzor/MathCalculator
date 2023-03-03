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
package ru.aleshin.mathcalculator.presentation.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MainDimens(
    val launcherIcon: Dp,
    val authorTitlePadding: Dp,
)

val baseMainDimens = MainDimens(
    launcherIcon = 64.dp,
    authorTitlePadding = 18.dp,
)

val LocalMainDimens = staticCompositionLocalOf<MainDimens> {
    error("Main Dimens is not provided")
}