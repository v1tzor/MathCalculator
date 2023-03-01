package ru.aleshin.mathcalculator.presentation.ui.splash

import androidx.compose.foundation.Image // ktlint-disable import-ordering
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
// import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import ru.aleshin.core.ui.theme.MathCalculatorTheme
import ru.aleshin.mathcalculator.presentation.theme.MainThemeRes

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
@Composable
fun SplashContent(
    onSplashExit: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.size(MainThemeRes.dimens.launcherIcon),
            painter = painterResource(id = MainThemeRes.icons.launcher),
            contentDescription = MainThemeRes.strings.launcherIconDesc,
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MainThemeRes.dimens.authorTitlePadding),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Text(
            text = MainThemeRes.strings.authorTitle,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surfaceVariant,
        )
    }

    LaunchedEffect(key1 = Unit) {
        delay(1500L)
        onSplashExit.invoke()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashContent_Preview() {
    MathCalculatorTheme {
        SplashContent(onSplashExit = {})
    }
}