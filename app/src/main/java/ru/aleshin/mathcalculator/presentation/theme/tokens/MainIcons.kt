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

import androidx.compose.runtime.compositionLocalOf
import ru.aleshin.mathcalculator.R

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MainIcons(
    val launcher: Int,
)

val baseMainIcons = MainIcons(
    launcher = R.drawable.ic_calculate,
)

val LocalMainIcons = compositionLocalOf<MainIcons> {
    error("Main Icons is not provided")
}