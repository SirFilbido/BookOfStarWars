package com.sirfilbido.bookofstarwars.domain.model

data class Planet(
    val id: Int = 0,
    val name: String = "",
    val rotationPeriod: Int = 0,
    val orbitalPeriod: Int = 0,
    val diameter: Int = 0,
    val climate: String = "",
    val gravity: String = "",
    val terrain: String = "",
    val surfaceWater: Int = 0,
    val population: Long = 0,
    val url: String = "",
)

