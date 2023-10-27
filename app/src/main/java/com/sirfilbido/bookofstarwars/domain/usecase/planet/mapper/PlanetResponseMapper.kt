package com.sirfilbido.bookofstarwars.domain.usecase.planet.mapper

import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse
import com.sirfilbido.bookofstarwars.domain.model.Planet
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl

fun PlanetResponse.toPlanet(): Planet =
    this.let {
        Planet(
            id = it.url.getIdUrl(),
            name = it.name,
            rotationPeriod = it.rotationPeriod.toInt(),
            orbitalPeriod = it.orbitalPeriod.toInt(),
            diameter = it.diameter.toInt(),
            climate = it.climate,
            gravity = it.gravity,
            terrain = it.terrain,
            surfaceWater = it.surfaceWater.toInt(),
            population = it.population.toLong(),
            url = it.url,
        )
    }