package com.sirfilbido.bookofstarwars.domain.model

data class CharacterList(
    val id: Int,
    val name: String = "",
    val birthYear: String = "",
    val gender: String = "",
)
