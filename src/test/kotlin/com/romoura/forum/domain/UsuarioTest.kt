package com.romoura.forum.domain

object UsuarioTest {
    fun build() = Usuario(
        id = 1,
        nome = "Romão",
        email = "romao@gmail.com",
        senha = "12345",
        role = mutableListOf()
    )
    fun buildToToken() = Usuario(nome = "Romão", email = "romao@gmail.com", senha = "12345")
}