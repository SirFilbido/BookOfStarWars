package com.sirfilbido.bookofstarwars.utils.extensions

fun String.getIdUrl(): Int {
    val regex = Regex("""/(\d+)/$""")

    val matchResult = regex.find(this)
    return matchResult?.groupValues?.get(1)?.toInt() ?: 0
}

fun String.stringToList(): List<String> {
    return this.split(",").map { it.trim() }
}