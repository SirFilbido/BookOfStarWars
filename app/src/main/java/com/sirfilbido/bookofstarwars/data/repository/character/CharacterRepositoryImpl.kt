package com.sirfilbido.bookofstarwars.data.repository.character

import android.os.RemoteException
import com.sirfilbido.bookofstarwars.data.remote.character.CharacterRemote
import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException

class CharacterRepositoryImpl : CharacterRepository, KoinComponent {

    private val characterRemote: CharacterRemote by inject()

    override suspend fun getListCharacter(): List<CharacterResponse> {
        return try {
            val response = characterRemote.getAllCharacter()
            response.result
        } catch (error: HttpException) {
            throw RemoteException("Unable to retrieve characters in SWApi")
        }
    }

    override suspend fun getCharacterById(id: Int): CharacterResponse {
        return try {
            characterRemote.getCharacterById(id)
        } catch (error: HttpException) {
            throw RemoteException("Unable to retrieve character by id in SWApi")
        }
    }
}