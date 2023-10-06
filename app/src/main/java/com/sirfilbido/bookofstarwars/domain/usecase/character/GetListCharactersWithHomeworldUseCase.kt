package com.sirfilbido.bookofstarwars.domain.usecase.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.domain.model.CharacterListWithHomeworld
import com.sirfilbido.bookofstarwars.domain.usecase.planet.GetPlanetByIdUseCase
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetListCharactersWithHomeworldUseCase : KoinComponent {

    private val repository: CharacterRepository by inject()
    private val getPlanetByIdUseCase: GetPlanetByIdUseCase by inject()


    //TODO Adicionar paginação
    suspend operator fun invoke(): List<CharacterListWithHomeworld> =
        listCharacterResponseToModel(repository.getListCharacter())

    private suspend fun listCharacterResponseToModel(
        characterResponse: List<CharacterResponse>
    ): List<CharacterListWithHomeworld> =

        characterResponse.let { listCharacterResponse ->
            val list = mutableListOf<CharacterListWithHomeworld>()

            listCharacterResponse.forEach { list.add(characterResponseToModel(it)) }

            list
        }

    private suspend fun characterResponseToModel(
        characterResponse: CharacterResponse
    ): CharacterListWithHomeworld =

        characterResponse.let {

            val planet = getPlanetByIdUseCase(it.homeworld.getIdUrl())

            CharacterListWithHomeworld(
                id = it.url.getIdUrl(),
                name = it.name,
                birthYear = it.birthYear,
                gender = it.gender,
                homeworld = planet,
            )
        }
}