package com.sirfilbido.bookofstarwars.utils.extensions

fun String.getIdUrl(): Int {
    val regex = Regex("""/(\d+)/$""")

    val matchResult = regex.find(this)
    return matchResult?.groupValues?.get(1)?.toInt() ?: 0
}

fun String.stringToList(): List<String> {
    return this.split(",").map { it.trim() }
}

fun String.normalize(): String {
    return if (this.uppercase() == "N/A") {
        "Not applicable"
    } else {
        this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}

fun String.isNA(): Boolean {
    return this.uppercase() == "N/A" || this.uppercase() == "NOT APPLICABLE"
}

fun String.isNotNA(): Boolean {
    return !this.isNA()
}