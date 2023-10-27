package com.sirfilbido.bookofstarwars.ui.navigation

sealed class Screen(val route: String) {
    object ListCharacterScreen : Screen("list_character_screen")
    object DetailCharacterScreen : Screen("detail_character_screen")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
