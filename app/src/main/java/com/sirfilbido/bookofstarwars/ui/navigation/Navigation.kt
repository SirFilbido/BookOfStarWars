package com.sirfilbido.bookofstarwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter.DetailCharacterScreen
import com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.ListCharacterScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ListCharacterScreen.route) {

        composable(route = Screen.ListCharacterScreen.route) {
            ListCharacterScreen(navController = navController)
        }

        composable(
            route = Screen.DetailCharacterScreen.route + "/{id}/{name}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            val name = it.arguments?.getString("name").toString()
            DetailCharacterScreen(navController = navController, id = id, name = name)
        }

    }
}
