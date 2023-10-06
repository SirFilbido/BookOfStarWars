package com.sirfilbido.bookofstarwars.data.repository.planet

import android.os.RemoteException
import com.sirfilbido.bookofstarwars.data.remote.planet.PlanetRemote
import com.sirfilbido.bookofstarwars.character.service.response.PlanetResponse
import com.sirfilbido.bookofstarwars.domain.repository.planet.PlanetRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException

class PlanetRepositoryImpl : PlanetRepository, KoinComponent {

    private val remote: PlanetRemote by inject()

    override suspend fun getPlanetById(id: Int): PlanetResponse {
        return try {
            remote.getPlanetById(id)
        } catch (error: HttpException) {
            throw RemoteException("Unable to retrieve planet in SWApi")
        }
    }
}