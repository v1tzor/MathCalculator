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
package ru.aleshin.features.calculator.impl.presentation.theme.tokens

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal data class CalculatorStrings(
    val calculatorTitle: String,
    val settingsIconDesc: String,
    val historyIconDesc: String,
    val moreIconDesc: String,
    val sumButtonTitle: String,
    val differenceButtonTitle: String,
    val clearLastButtonTitle: String,
    val clearAllButtonTitle: String,
    val nineButtonTitle: String,
    val eightButtonTitle: String,
    val sevenButtonTitle: String,
    val sixButtonTitle: String,
    val fiveButtonTitle: String,
    val fourButtonTitle: String,
    val threeButtonTitle: String,
    val twoButtonTitle: String,
    val oneButtonTitle: String,
    val zeroButtonTitle: String,
    val resultButtonTitle: String,
    val emptyButtonTitle: String,
    val dotButtonTitle: String,
    val multiplyButtonTitle: String,
    val splitButtonTitle: String,
)

internal val russianSettingsString = CalculatorStrings(
    calculatorTitle = "Калькулятор",
    settingsIconDesc = "Настройки",
    historyIconDesc = "История",
    moreIconDesc = "Дополнительно",
    nineButtonTitle = "9",
    eightButtonTitle = "8",
    sevenButtonTitle = "7",
    sixButtonTitle = "6",
    fiveButtonTitle = "5",
    fourButtonTitle = "4",
    threeButtonTitle = "3",
    twoButtonTitle = "2",
    oneButtonTitle = "1",
    zeroButtonTitle = "0",
    sumButtonTitle = "+",
    differenceButtonTitle = "-",
    clearLastButtonTitle = "⌫",
    clearAllButtonTitle = "C",
    resultButtonTitle = "=",
    emptyButtonTitle = " ",
    splitButtonTitle = "/",
    multiplyButtonTitle = "*",
    dotButtonTitle = ".",
)

internal val englishSettingsString = CalculatorStrings(
    calculatorTitle = "Сalculator",
    settingsIconDesc = "Settings",
    historyIconDesc = "History",
    moreIconDesc = "More",
    nineButtonTitle = "9",
    eightButtonTitle = "8",
    sevenButtonTitle = "7",
    sixButtonTitle = "6",
    fiveButtonTitle = "5",
    fourButtonTitle = "4",
    threeButtonTitle = "3",
    twoButtonTitle = "2",
    oneButtonTitle = "1",
    zeroButtonTitle = "0",
    sumButtonTitle = "+",
    differenceButtonTitle = "-",
    clearLastButtonTitle = "⌫",
    clearAllButtonTitle = "C",
    resultButtonTitle = "=",
    emptyButtonTitle = " ",
    splitButtonTitle = "/",
    multiplyButtonTitle = "*",
    dotButtonTitle = ".",
)

internal val LocalCalculatorStrings = staticCompositionLocalOf<CalculatorStrings> {
    error("Settings Strings is not provided")
}
