/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
object Dependencies {

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.core}"

        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "androidx.compose.material3:material3:${Versions.material}"
        const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"

        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val placeHolder = "com.google.accompanist:accompanist-placeholder-material:${Versions.accompanist}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }

    object Voyager {
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyager}"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyager}"
        const val screenModel = "cafe.adriel.voyager:voyager-androidx:${Versions.voyager}"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.dagger}"
        const val kapt = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Room {
        const val core = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val kapt = "androidx.room:room-compiler:${Versions.room}"
    }

    object Test {
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val composeJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
        const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}
