package com.sirfilbido.bookofstarwars.domain.usecase.character

import com.sirfilbido.bookofstarwars.domain.model.Character
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.domain.usecase.character.mapper.toCharacter
import com.sirfilbido.bookofstarwars.domain.usecase.planet.GetPlanetByIdUseCase
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCharacterByIdUseCase : KoinComponent {

    private val repository: CharacterRepository by inject()
    private val getPlanetByIdUseCase: GetPlanetByIdUseCase by inject()

    suspend operator fun invoke(id: Int): Character {
        val characterResponse = repository.getCharacterById(id)
        val planet = getPlanetByIdUseCase(characterResponse.homeworld.getIdUrl())
        return characterResponse.toCharacter(planet)
    }
}

