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

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
data class MathCalculatorStrings(
    val appName: String,
    val alertDialogDismissTitle: String,
    val alertDialogConfirmTitle: String
)

internal val russianMathCalculatorString = MathCalculatorStrings(
    appName = "MathCalculator",
    alertDialogDismissTitle = "Отмена",
    alertDialogConfirmTitle = "Выбрать",
)

internal val englishMathCalculatorString = MathCalculatorStrings(
    appName = "MathCalculator",
    alertDialogDismissTitle = "Cancel",
    alertDialogConfirmTitle = "OK",
)

val LocalMathCalculatorStrings = staticCompositionLocalOf<MathCalculatorStrings> {
    error("Core Strings is not provided")
}
