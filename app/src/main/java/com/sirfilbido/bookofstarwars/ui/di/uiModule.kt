package com.sirfilbido.bookofstarwars.ui.di

import com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.ListCharacterViewModel
import com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter.DetailsCharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun uiModule() = arrayListOf(
    viewModelModule,
)

private val viewModelModule = module {
    viewModelOf(::ListCharacterViewModel)
    viewModelOf(::DetailsCharacterViewModel)
}