package com.sirfilbido.bookofstarwars.domain.repository.planet

import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse

interface PlanetRepository {

    suspend fun getPlanetById(id: Int): PlanetResponse
}