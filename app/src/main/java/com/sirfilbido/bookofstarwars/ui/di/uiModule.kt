package com.sirfilbido.bookofstarwars.ui.di

import org.koin.dsl.module

fun uiModule() = arrayListOf(
    viewModelModule,
)

private val viewModelModule = module {
//    viewModel { HomeViewModel(get()) }
}