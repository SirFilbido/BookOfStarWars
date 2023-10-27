package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.domain.usecase.character.GetListCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListCharacterViewModel(
    private val useCase: GetListCharactersUseCase
) : ViewModel() {

    private val _listCharacterState = MutableStateFlow(listOf<CharacterList>())
    val listCharacterState = _listCharacterState.asStateFlow()

    suspend fun fetchCharacters() {
        viewModelScope.launch {
            val list = useCase.invoke()
            _listCharacterState.value = list
        }
    }
}