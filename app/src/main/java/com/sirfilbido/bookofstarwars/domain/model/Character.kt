package com.sirfilbido.bookofstarwars.domain.model

data class Character(
    val id: Int = 0,
    val name: String = "",
    val height: Int = 0,
    val mass: Int = 0,
    val hairColor: List<String>? = null,
    val skinColor: String = "",
    val eyeColor: String = "",
    val birthYear: String = "",
    val gender: String? = null,
    val homeworld: Planet? = null,
    val url: String = "",
)
