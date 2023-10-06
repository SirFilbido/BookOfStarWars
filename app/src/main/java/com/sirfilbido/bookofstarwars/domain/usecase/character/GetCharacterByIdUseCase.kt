package com.sirfilbido.bookofstarwars.domain.usecase.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.domain.model.Character
import com.sirfilbido.bookofstarwars.domain.model.Planet
import com.sirfilbido.bookofstarwars.domain.usecase.planet.GetPlanetByIdUseCase
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import com.sirfilbido.bookofstarwars.utils.extensions.stringToList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCharacterByIdUseCase : KoinComponent {

    private val repository: CharacterRepository by inject()
    private val getPlanetByIdUseCase: GetPlanetByIdUseCase by inject()

    suspend operator fun invoke(id: Int): Character {
        val characterResponse = repository.getCharacterById(id)
        val planet = getPlanetByIdUseCase(characterResponse.homeworld.getIdUrl())
        return responseToModel(characterResponse, planet)
    }

    private fun responseToModel(characterResponse: CharacterResponse, planet: Planet): Character =
        characterResponse.let {
            Character(
                id = it.url.getIdUrl(),
                name = it.name,
                height = it.height.toInt(),
                mass = it.mass.toInt(),
                hairColor = it.hairColor.stringToList(),
                skinColor = it.skinColor,
                eyeColor = it.eyeColor,
                birthYear = it.birthYear,
                gender = it.gender,
                homeworld = planet,
                url = it.url,
            )
        }
}

