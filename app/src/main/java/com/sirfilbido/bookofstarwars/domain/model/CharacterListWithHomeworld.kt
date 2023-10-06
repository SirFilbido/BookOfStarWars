package com.sirfilbido.bookofstarwars.domain.model

data class CharacterListWithHomeworld(
    val id: Int,
    val name: String,
    val birthYear: String,
    val gender: String?,
    val homeworld: Planet,
)
