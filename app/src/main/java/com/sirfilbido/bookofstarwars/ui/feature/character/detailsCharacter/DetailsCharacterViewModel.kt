package com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirfilbido.bookofstarwars.domain.model.Character
import com.sirfilbido.bookofstarwars.domain.usecase.character.GetCharacterByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsCharacterViewModel (
    private val useCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _characterState = MutableStateFlow(Character())
    val characterState = _characterState.asStateFlow()

    suspend fun fetchCharacter(id: Int) {
        viewModelScope.launch {
            val character = useCase.invoke(id)
            _characterState.value = character
        }
    }
}
