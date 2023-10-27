package com.sirfilbido.bookofstarwars.utils.extensions

fun Int.formatMass(): String {
    return "${this}kg"
}

fun Int.formatHeight(): String {
    val meters = this / 100
    val centimeters = this % 100

    return if (meters >= 1) {

        val centimetersPart =
            if (centimeters == 0) "00" else "$centimeters"

        "$meters.${centimetersPart}m"
    } else {
        "${centimeters}cm"
    }
}