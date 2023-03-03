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
package ru.aleshin.core.ui.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import ru.aleshin.core.ui.R

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MathCalculatorIcons(
    val back: Int,
)

internal val baseMathCalculatorIcons = MathCalculatorIcons(
    back = R.drawable.ic_back,
)

val LocalMathCalculatorIcons = staticCompositionLocalOf<MathCalculatorIcons> {
    error("Core Icons is not provided")
}
