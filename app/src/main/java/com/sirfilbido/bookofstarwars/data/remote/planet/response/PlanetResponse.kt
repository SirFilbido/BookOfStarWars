package com.sirfilbido.bookofstarwars.character.service.response

import com.squareup.moshi.Json

class PlanetResponse(
    val name: String,
    @Json(name = "rotation_period")
    val rotationPeriod: String,
    @Json(name = "orbital_period")
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @Json(name = "surface_water")
    val surfaceWater: String,
    val population: String,
    val url: String,
)