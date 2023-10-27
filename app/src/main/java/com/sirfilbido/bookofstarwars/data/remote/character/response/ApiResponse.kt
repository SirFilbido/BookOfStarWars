package com.sirfilbido.bookofstarwars.data.remote.character.response

class ApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<CharacterResponse> //TODO Verificar como deixar essa classe com esse typo generico ou para ser usado por outras requisições
)