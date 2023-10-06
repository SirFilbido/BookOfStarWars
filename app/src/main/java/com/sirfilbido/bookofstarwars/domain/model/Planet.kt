package com.sirfilbido.bookofstarwars.domain.model

data class Planet(
    val id: Int,
    val name: String,
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val diameter: Int,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: Int,
    val population: Int,
    val url: String,
)

