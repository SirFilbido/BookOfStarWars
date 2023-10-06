package com.sirfilbido.bookofstarwars.data.remote.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.ApiResponse
import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterRemote {

    @GET("people/")
    suspend fun getAllCharacter(): ApiResponse

    @GET("people/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterResponse

}