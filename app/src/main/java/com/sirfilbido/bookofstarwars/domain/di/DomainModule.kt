package com.sirfilbido.bookofstarwars.domain.di

import com.sirfilbido.bookofstarwars.data.repository.character.CharacterRepositoryImpl
import com.sirfilbido.bookofstarwars.data.repository.planet.PlanetRepositoryImpl
import com.sirfilbido.bookofstarwars.domain.repository.character.CharacterRepository
import com.sirfilbido.bookofstarwars.domain.repository.planet.PlanetRepository
import com.sirfilbido.bookofstarwars.domain.usecase.character.GetCharacterByIdUseCase
import com.sirfilbido.bookofstarwars.domain.usecase.character.GetListCharactersUseCase
import com.sirfilbido.bookofstarwars.domain.usecase.character.GetListCharactersWithHomeworldUseCase
import com.sirfilbido.bookofstarwars.domain.usecase.planet.GetPlanetByIdUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun domainModule() = arrayListOf(
    repositoryModule,
    useCaseCharacterModule,
    useCasePlanetModule,
)

private val repositoryModule = module {
    factory<CharacterRepository> { CharacterRepositoryImpl() }
    factory<PlanetRepository> { PlanetRepositoryImpl() }
}

private val useCaseCharacterModule = module {
    factoryOf(::GetCharacterByIdUseCase)
    factoryOf(::GetListCharactersUseCase)
    factoryOf(::GetListCharactersWithHomeworldUseCase)
}

private val useCasePlanetModule = module {
    factoryOf(::GetPlanetByIdUseCase)
}