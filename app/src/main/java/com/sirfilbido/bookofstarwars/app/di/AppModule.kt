package com.sirfilbido.bookofstarwars.app.di

import com.sirfilbido.bookofstarwars.data.di.dataModule
import com.sirfilbido.bookofstarwars.domain.di.domainModule
import com.sirfilbido.bookofstarwars.ui.di.uiModule
import org.koin.core.module.Module

fun appModule() = arrayListOf<Module>().apply {
    addAll(dataModule())
    addAll(domainModule())
    addAll(uiModule())
}

