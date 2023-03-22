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
package ru.aleshin.features.history.impl.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.aleshin.core.ui.theme.MathCalculatorRes
import ru.aleshin.core.ui.theme.tokens.MathCalculatorLanguage
import ru.aleshin.features.history.impl.presentation.theme.tokens.*
import ru.aleshin.features.history.impl.presentation.theme.tokens.LocalHistoryIcons
import ru.aleshin.features.history.impl.presentation.theme.tokens.LocalHistoryStrings
import ru.aleshin.features.history.impl.presentation.theme.tokens.baseHistoryIcons
import ru.aleshin.features.history.impl.presentation.theme.tokens.russianHistoryStrings

/**
 * @author Stanislav Aleshin on 21.03.2023.
 */
@Composable
internal fun HistoryTheme(content: @Composable () -> Unit) {
    val strings = when (MathCalculatorRes.language) {
        MathCalculatorLanguage.EN -> englishHistoryStrings
        MathCalculatorLanguage.RU -> russianHistoryStrings
    }

    CompositionLocalProvider(
        LocalHistoryStrings provides strings,
        LocalHistoryIcons provides baseHistoryIcons,
        content = content,
    )
}