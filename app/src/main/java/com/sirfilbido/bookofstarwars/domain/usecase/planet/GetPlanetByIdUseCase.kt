package com.sirfilbido.bookofstarwars.domain.usecase.planet

import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse
import com.sirfilbido.bookofstarwars.domain.repository.planet.PlanetRepository
import com.sirfilbido.bookofstarwars.domain.model.Planet
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPlanetByIdUseCase : KoinComponent {

    private val repository: PlanetRepository by inject()

    suspend operator fun invoke(id: Int): Planet =
        responseToModel(repository.getPlanetById(id))

    private fun responseToModel(planetResponse: PlanetResponse): Planet =
        planetResponse.let {
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
                population = it.population.toInt(),
                url = it.url,
            )
        }
}