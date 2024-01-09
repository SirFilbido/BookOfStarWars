package com.sirfilbido.bookofstarwars.domain.usecase.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.model.CharacterListWithHomeworld
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.data.mappers.character.toCharacterListWithHomeworld
import com.sirfilbido.bookofstarwars.domain.usecase.planet.GetPlanetByIdUseCase
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetListCharactersWithHomeworldUseCase : KoinComponent {

    private val repository: CharacterRepository by inject()
    private val getPlanetByIdUseCase: GetPlanetByIdUseCase by inject()


    //TODO Adicionar paginação
    suspend operator fun invoke(): List<CharacterListWithHomeworld> =
        listCharacterResponseToModel(repository.getListCharacter(1).results)

    private suspend fun listCharacterResponseToModel(
        characterResponse: List<CharacterResponse>
    ): List<CharacterListWithHomeworld> =

        characterResponse.let { listCharacterResponse ->
            val list = mutableListOf<CharacterListWithHomeworld>()

            listCharacterResponse.forEach { characterResponse ->
                val planet = getPlanetByIdUseCase(characterResponse.homeworld.getIdUrl())

                list.add(characterResponse.toCharacterListWithHomeworld(planet))
            }

            list
        }
}