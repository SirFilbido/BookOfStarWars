package com.sirfilbido.bookofstarwars.ui.components.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sirfilbido.bookofstarwars.ui.components.appBar.BoSWTopAppBar
import com.sirfilbido.bookofstarwars.ui.theme.CoruscantBlue

@Composable
fun BoSWScreen(
    navController: NavController,
    hasToolbar: Boolean = true,
    titleToolbar: String? = null,
    isBackStack: Boolean = true,
    content: @Composable () -> Unit,
    backgroundColor: Color = CoruscantBlue,
    isLoading: Boolean = false,
    loadingContent: @Composable (() -> Unit)? = null,
) {
    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            if (hasToolbar) {
                BoSWTopAppBar(
                    navController = navController,
                    title = titleToolbar,
                    isBackStack = isBackStack
                )
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isLoading) {
                if (loadingContent != null)
                    loadingContent()
                else {
                    //TODO Adicionar um loading padrão ou a splash screen
                }
            } else {
                content()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BoSWScreenPreview() {
    BoSWScreen(
        navController = rememberNavController(),
        content = { },
    )
}

@Preview(showSystemUi = true)
@Composable
fun BoSWScreenPreviewWithoutTopBar() {
    BoSWScreen(
        navController = rememberNavController(),
        hasToolbar = false,
        content = { },
    )
}

@Preview(showSystemUi = true)
@Composable
fun BoSWScreenPreviewWithLoading() {
    BoSWScreen(
        navController = rememberNavController(),
        content = { },
        isLoading = true
    )
}