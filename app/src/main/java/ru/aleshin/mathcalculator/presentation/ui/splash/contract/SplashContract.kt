package ru.aleshin.mathcalculator.presentation.ui.splash.contract // ktlint-disable filename

import kotlinx.parcelize.Parcelize
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseAction
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEffect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseEvent
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Parcelize
sealed class SplashViewState : BaseViewState {
    object Defualt : SplashViewState()
}

sealed class SplashEvent : BaseEvent {
    object AfterSplash : SplashEvent()
}

sealed class SplashEffect : BaseEffect {
    object NavigateToCalculator : SplashEffect()
}

sealed class SplashAction : SplashEffect(), BaseAction
