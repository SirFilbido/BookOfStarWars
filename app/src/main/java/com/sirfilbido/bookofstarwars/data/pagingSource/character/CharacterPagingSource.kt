package com.sirfilbido.bookofstarwars.data.pagingSource.character

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.utils.extensions.getPageFromUrl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private const val STARTING_PAGE_INDEX = 1

class CharacterPagingSource : KoinComponent, PagingSource<Int, CharacterResponse>() {

    private val repository: CharacterRepository by inject()

    override fun getRefreshKey(state: PagingState<Int, CharacterResponse>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResponse> {
        return try {
            val page = params.key ?: STARTING_PAGE_INDEX
            val response = repository.getListCharacter(page)

            Page(
                data = response.results,
                nextKey = response.next.getPageFromUrl(),
                prevKey = response.previous.getPageFromUrl(),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
