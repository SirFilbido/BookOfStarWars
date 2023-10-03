package com.sirfilbido.bookofstarwars.common.di

import com.sirfilbido.bookofstarwars.character.di.characterModule
import org.koin.core.module.Module

fun appModule() = arrayListOf<Module>().apply {
    addAll(characterModule())
}

