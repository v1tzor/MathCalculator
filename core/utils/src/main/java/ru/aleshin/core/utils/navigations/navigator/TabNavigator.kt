package ru.aleshin.core.utils.navigations.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
fun TabNavigator(
    navigatorManager: NavigatorManager,
    content: NavigatorContent,
) {
    Navigator(
        screen = EmptyScreen,
        disposeBehavior = NavigatorDisposeBehavior(
            disposeNestedNavigators = false,
            disposeSteps = false,
        ),
        onBackPressed = null,
    ) { navigator ->
        DisposableEffect(Unit) {
            navigatorManager.attachNavigator(navigator)
            onDispose { navigatorManager.detachNavigator() }
        }
        content.invoke(navigator)
    }
}

object EmptyScreen : Screen {
    @Composable
    override fun Content() = Unit
}