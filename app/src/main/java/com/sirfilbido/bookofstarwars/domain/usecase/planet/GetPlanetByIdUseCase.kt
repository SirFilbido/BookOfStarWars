package com.sirfilbido.bookofstarwars.domain.usecase.planet

import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse
import com.sirfilbido.bookofstarwars.domain.repository.planet.PlanetRepository
import com.sirfilbido.bookofstarwars.domain.model.Planet
import com.sirfilbido.bookofstarwars.domain.usecase.planet.mapper.toPlanet
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPlanetByIdUseCase : KoinComponent {

    private val repository: PlanetRepository by inject()

    suspend operator fun invoke(id: Int): Planet = repository.getPlanetById(id).toPlanet()
}