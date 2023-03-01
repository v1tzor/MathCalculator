package ru.aleshin.mathcalculator.presentation.ui.main.viewmodel

import ru.aleshin.core.utils.managers.CoroutineManager
import ru.aleshin.core.utils.platform.screenmodel.BaseViewModel
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainAction
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainEffect
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainEvent
import ru.aleshin.mathcalculator.presentation.ui.main.contract.MainViewState
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
class MainViewModel @Inject constructor(
    communicator: MainStateCommunicator,
    actor: MainActor,
    coroutineManager: CoroutineManager,
) : BaseViewModel<MainViewState, MainEvent, MainAction, MainEffect>(
    stateCommunicator = communicator,
    actor = actor,
    coroutineManager = coroutineManager,
) {

    init {
        dispatchEvent(MainEvent.Init)
    }

    override fun handleEffect(effect: MainEffect) = when (effect) {
        is MainAction -> runOnBackground {
            val currentState = stateCommunicator.read()
            val newState = reduce(effect, currentState)

            stateCommunicator.update(newState)
        }
    }

    override fun reduce(action: MainAction, currentState: MainViewState) = when (action) {
        is MainAction.ChangeThemeSettings -> currentState.copy(
            language = action.language,
            colors = action.themeColors,
        )
    }

    class Factory @Inject constructor(viewModel: Provider<MainViewModel>) :
        BaseViewModel.Factory(viewModel)
}
