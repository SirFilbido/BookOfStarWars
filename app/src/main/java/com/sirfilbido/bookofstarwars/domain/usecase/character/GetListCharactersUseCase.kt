package com.sirfilbido.bookofstarwars.domain.usecase.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.domain.usecase.character.mapper.toCharacterList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetListCharactersUseCase : KoinComponent {

    private val repository: CharacterRepository by inject()

    //TODO Adicionar paginação
    suspend operator fun invoke(): List<CharacterList> =
        listCharacterResponseToModel(repository.getListCharacter())

    private fun listCharacterResponseToModel(characterResponse: List<CharacterResponse>): List<CharacterList> =
        characterResponse.let { listCharacterResponse ->
            val list = mutableListOf<CharacterList>()

            listCharacterResponse.forEach { characterResponse ->
                list.add(characterResponse.toCharacterList())
            }

            list
        }
}