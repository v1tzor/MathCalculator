package ru.aleshin.core.utils.platform.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import ru.aleshin.core.utils.platform.communications.state.ViewStateCollect
import ru.aleshin.core.utils.platform.screenmodel.contract.BaseViewState

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
fun <S : BaseViewState> rememberViewState(
    stateProvider: ViewStateCollect<S>,
    initialValue: S,
): S {
    val state = rememberSaveable { mutableStateOf(initialValue) }
    LaunchedEffect(Unit) {
        stateProvider.collectState { state.value = it }
    }

    return state.value
}
