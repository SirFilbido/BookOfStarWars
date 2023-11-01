package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.domain.usecase.character.GetListCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListCharacterViewModel(
    private val useCase: GetListCharactersUseCase
) : ViewModel() {

    private val _listCharacterState: MutableStateFlow<PagingData<CharacterList>> = MutableStateFlow(PagingData.empty())
    val listCharacterState = _listCharacterState


    init {
        viewModelScope.launch {
            fetchCharacters()
        }
    }

    private suspend fun fetchCharacters() {
        viewModelScope.launch {
            useCase.invoke().cachedIn(viewModelScope).collect {
                _listCharacterState.value = it
            }
        }
    }
}