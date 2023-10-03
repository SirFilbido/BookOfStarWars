package com.sirfilbido.bookofstarwars.character.di

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.sirfilbido.bookofstarwars.common.network.RetrofitService
import org.koin.dsl.module

fun characterModule() = arrayListOf(
    retrofitModule,
    repositoryModule
)

val repositoryModule = module {

}

val retrofitModule = module {
    single {
        RetrofitService.retrofit.create(T::class.java)
    }
}