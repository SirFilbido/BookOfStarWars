package com.sirfilbido.bookofstarwars.data.di

import com.sirfilbido.bookofstarwars.data.remote.character.CharacterRemote
import com.sirfilbido.bookofstarwars.data.remote.planet.PlanetRemote
import com.sirfilbido.bookofstarwars.app.network.RetrofitService
import org.koin.dsl.module

fun dataModule() = arrayListOf(
    remoteModule,
)

private val remoteModule = module {
    factory<CharacterRemote> { RetrofitService.retrofit.create(CharacterRemote::class.java) }
    factory<PlanetRemote> { RetrofitService.retrofit.create(PlanetRemote::class.java) }
}
