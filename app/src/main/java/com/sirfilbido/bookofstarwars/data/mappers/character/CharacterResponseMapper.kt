package com.sirfilbido.bookofstarwars.data.mappers.character

import com.sirfilbido.bookofstarwars.data.remote.character.response.CharacterResponse
import com.sirfilbido.bookofstarwars.domain.model.Character
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.domain.model.CharacterListWithHomeworld
import com.sirfilbido.bookofstarwars.domain.model.Planet
import com.sirfilbido.bookofstarwars.utils.extensions.getIdUrl
import com.sirfilbido.bookofstarwars.utils.extensions.normalizeInt
import com.sirfilbido.bookofstarwars.utils.extensions.stringToList

fun CharacterResponse.toCharacter(planet: Planet): Character =
    this.let {
        Character(
            id = it.url.getIdUrl(),
            name = it.name,
            height = if (it.height != "unknown") it.height.normalizeInt() else 0,
            mass = if (it.mass != "unknown") it.mass.normalizeInt() else 0,
            hairColor = it.hairColor.stringToList(),
            skinColor = it.skinColor,
            eyeColor = it.eyeColor,
            birthYear = it.birthYear,
            gender = it.gender,
            homeworld = planet,
            url = it.url,
        )
    }

fun CharacterResponse.toCharacterList(): CharacterList =
    this.let {
        CharacterList(
            id = it.url.getIdUrl(),
            name = it.name,
            birthYear = it.birthYear,
            gender = it.gender,
        )
    }

fun CharacterResponse.toCharacterListWithHomeworld(planet: Planet): CharacterListWithHomeworld =
    this.let {
        CharacterListWithHomeworld(
            id = it.url.getIdUrl(),
            name = it.name,
            birthYear = it.birthYear,
            gender = it.gender,
            homeworld = planet,
        )
    }