package ru.aleshin.mathcalculator.presentation.ui.main.contract // ktlint-disable filename

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.aleshin.core.ui.theme.material.ThemeColorsUiType
import ru.aleshin.core.ui.theme.tokens.LanguageUiType
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
data class MainViewState(
    val language: LanguageUiType = LanguageUiType.DEFUALT,
    val colors: ThemeColorsUiType = ThemeColorsUiType.DEFUALT,
) : BaseViewState, Parcelable

sealed class MainEvent : BaseEvent {
    object Init : MainEvent()
}

sealed class MainEffect : BaseEffect

sealed class MainAction : MainEffect(), BaseAction {

    data class ChangeThemeSettings(
        val language: LanguageUiType,
        val themeColors: ThemeColorsUiType,
    ) : MainAction()
}
