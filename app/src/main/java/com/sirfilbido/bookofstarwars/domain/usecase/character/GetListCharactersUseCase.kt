package com.sirfilbido.bookofstarwars.domain.usecase.character

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.sirfilbido.bookofstarwars.data.mappers.character.toCharacterList
import com.sirfilbido.bookofstarwars.data.pagingSource.character.CharacterPagingSource
import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetListCharactersUseCase {

    operator fun invoke(): Flow<PagingData<CharacterList>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            //            prefetchDistance = 20
        ),
    ) {
        CharacterPagingSource()
    }
        .flow
        .map { value: PagingData<CharacterResponse> ->
            value.map { characterList: CharacterResponse ->
                characterList.toCharacterList()
            }
        }

    private fun listCharacterResponseToModel(characterResponse: List<CharacterResponse>): List<CharacterList> =
        characterResponse.let { listCharacterResponse ->
            val list = mutableListOf<CharacterList>()

            listCharacterResponse.forEach { characterResponse ->
                list.add(characterResponse.toCharacterList())
            }

            list
        }
}