package com.sirfilbido.bookofstarwars.domain.model

data class Character(
    val id: Int = 0,
    val name: String = "",
    val height: Int = 0,
    val mass: Int = 0,
    val hairColor: List<String> = listOf(),
    val skinColor: String = "",
    val eyeColor: String = "",
    val birthYear: String = "",
    val gender: String = "",
    val homeworld: Planet = Planet() ,
    val url: String = "",
)
