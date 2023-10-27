package com.sirfilbido.bookofstarwars.utils.extensions

fun List<String>.formatAsSentence(): String {
    return if (isEmpty()) {
        return ""
    } else {
        this.joinToString(", ") { sentence ->
            sentence.normalize()
        }
    }
}