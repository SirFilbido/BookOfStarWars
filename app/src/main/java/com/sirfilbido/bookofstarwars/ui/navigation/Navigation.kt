package com.sirfilbido.bookofstarwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sirfilbido.bookofstarwars.ui.navigation.Screen.ListCharacterScreen
import com.sirfilbido.bookofstarwars.ui.navigation.grafh.detailsCharacterScreen
import com.sirfilbido.bookofstarwars.ui.navigation.grafh.listCharacterScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListCharacterScreen.route) {

        //Character
        listCharacterScreen(navController)
        detailsCharacterScreen(navController)
    }
}
