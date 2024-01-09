package com.sirfilbido.bookofstarwars.utils.extensions

fun Int.formatMass(): String {
    return if (this == 0) "Unknown"
    else if (this > 999) "%,d".format(this).replace(',', '.').plus("kg")
    else "${this}kg"
}

fun Int.formatHeight(): String {
    val meters = this / 100
    val centimeters = this % 100

    return if (this == 0) "Unknown"
    else if (meters >= 1) {
        val centimetersPart = if (centimeters == 0) "00" else "$centimeters"
        "$meters.${centimetersPart}m"
    } else {
        "${centimeters}cm"
    }
}