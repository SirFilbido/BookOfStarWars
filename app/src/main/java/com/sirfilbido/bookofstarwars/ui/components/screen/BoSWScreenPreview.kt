package com.sirfilbido.bookofstarwars.ui.components.screen

import androidx.compose.runtime.Composable
import com.sirfilbido.bookofstarwars.app.di.appModule
import org.koin.compose.KoinApplication

// This function is used when the screen has a dependency injection
// from a viewModel or some other class via Koin
@Composable
fun ScreenPreview(
    screen: @Composable () -> Unit
) {
    KoinApplication(application = {
        modules(appModule())
    }) { screen() }
}