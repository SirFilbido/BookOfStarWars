package com.sirfilbido.bookofstarwars.data.mappers.planet

import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse
import com.sirfilbido.bookofstarwars.domain.model.Planet
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import com.sirfilbido.bookofstarwars.utils.extensions.normalize
import com.sirfilbido.bookofstarwars.utils.extensions.normalizeInt

fun PlanetResponse.toPlanet(): Planet =
    this.let {
        Planet(
            id = it.url.getIdUrl(),
            name = it.name.normalize(),
            rotationPeriod = if (it.rotationPeriod != "unknown") it.rotationPeriod.normalizeInt() else 0,
            orbitalPeriod = if (it.orbitalPeriod != "unknown") it.orbitalPeriod.normalizeInt() else 0,
            diameter = if (it.diameter != "unknown") it.diameter.normalizeInt() else 0,
            climate = it.climate,
            gravity = it.gravity,
            terrain = it.terrain,
            surfaceWater = if (it.surfaceWater != "unknown") it.surfaceWater.normalizeInt() else 0,
            population = if (it.population != "unknown") it.population.toLong() else 0,
            url = it.url,
        )
    }