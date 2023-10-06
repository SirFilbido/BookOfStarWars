package com.sirfilbido.bookofstarwars.domain.repository.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse

interface CharacterRepository {

    suspend fun getListCharacter(): List<CharacterResponse>

    suspend fun getCharacterById(id: Int): CharacterResponse
}