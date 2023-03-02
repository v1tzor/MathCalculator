package ru.aleshin.mathcalculator.presentation.ui.splash.screenmodel

import kotlinx.coroutines.flow.flowOf
import ru.aleshin.core.utils.platform.screenmodel.common.Actor
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEffect
import ru.aleshin.mathcalculator.presentation.ui.splash.contract.SplashEvent
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface SplashActor : Actor<SplashEvent, SplashEffect> {

    class Base @Inject constructor() : SplashActor {
        override fun handleEvent(event: SplashEvent) = when (event) {
            SplashEvent.AfterSplash -> flowOf(SplashEffect.NavigateToCalculator)
        }
    }
}
