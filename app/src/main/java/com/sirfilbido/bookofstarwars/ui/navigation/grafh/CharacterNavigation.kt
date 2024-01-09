package com.sirfilbido.bookofstarwars.ui.navigation.grafh

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter.DetailCharacterScreen
import com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.ListCharacterScreen
import com.sirfilbido.bookofstarwars.ui.navigation.Screen
import com.sirfilbido.bookofstarwars.ui.navigation.Screen.ListCharacterScreen

fun NavGraphBuilder.listCharacterScreen(navController: NavHostController) {
    composable(route = ListCharacterScreen.route) {
        ListCharacterScreen(navController = navController)
    }
}

fun NavGraphBuilder.detailsCharacterScreen(navController: NavHostController) {
    composable(
        route = Screen.DetailCharacterScreen.route + "/{id}/{name}",
        arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("name") { type = NavType.StringType }
        )
    ) {
        val id = it.arguments?.getInt("id") ?: 0
        val name = it.arguments?.getString("name").toString()

        DetailCharacterScreen(navController = navController, id = id, name = name)
    }
}