package com.sirfilbido.bookofstarwars.data.remote.planet

import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetRemote {

    @GET("planets/{id}")
    suspend fun getPlanetById(@Path("id") id: Int): PlanetResponse
}