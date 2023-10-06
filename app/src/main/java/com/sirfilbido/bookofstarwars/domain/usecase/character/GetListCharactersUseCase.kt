package com.sirfilbido.bookofstarwars.domain.usecase.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
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

            listCharacterResponse.forEach { list.add(characterResponseToModel(it)) }

            list
        }

    private fun characterResponseToModel(characterResponse: CharacterResponse): CharacterList =
        characterResponse.let {
            CharacterList(
                id = it.url.getIdUrl(),
                name = it.name,
                birthYear = it.birthYear,
                gender = it.gender,
            )
        }
}