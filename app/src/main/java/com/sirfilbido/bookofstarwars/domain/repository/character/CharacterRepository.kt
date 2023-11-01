package com.sirfilbido.bookofstarwars.domain.repository.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.ApiResponse
import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse

interface CharacterRepository {

    suspend fun getListCharacter(page: Int): ApiResponse

    suspend fun getCharacterById(id: Int): CharacterResponse
}