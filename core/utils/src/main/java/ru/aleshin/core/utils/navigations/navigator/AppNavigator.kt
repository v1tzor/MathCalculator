package ru.aleshin.core.utils.navigations.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.transitions.FadeTransition

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
@OptIn(ExperimentalAnimationApi::class)
fun AppNavigator(
    initialScreen: Screen,
    navigatorManager: NavigatorManager,
    content: NavigatorContent = { FadeTransition(navigator = it) },
) {
    Navigator(
        initialScreen,
        disposeBehavior = NavigatorDisposeBehavior(disposeNestedNavigators = false),
    ) { navigator ->
        DisposableEffect(Unit) {
            navigatorManager.attachNavigator(navigator)
            onDispose { navigatorManager.detachNavigator() }
        }
        content.invoke(navigator)
    }
}