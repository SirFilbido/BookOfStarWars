package com.sirfilbido.bookofstarwars.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sirfilbido.bookofstarwars.ui.theme.CoruscantBlue

@Composable
fun ScreenBoSW(
    navController: NavController,
    titleToolbar: String,
    isBackStack: Boolean = true,
    content: @Composable () -> Unit,
) {
    Scaffold(
        containerColor = CoruscantBlue,
        topBar = {
            TopAppBarBoSW(
                navController = navController,
                title = titleToolbar,
                isBackStack = isBackStack
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            content()
        }
    }
}