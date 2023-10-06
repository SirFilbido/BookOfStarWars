package com.sirfilbido.bookofstarwars.domain.model

data class Character(
    val id: Int,
    val name: String,
    val height: Int,
    val mass: Int,
    val hairColor: List<String>?,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String?,
    val homeworld: Planet,
    val url: String,
)
