package com.romoura.forum.service

import com.romoura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario>
) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Romão",
            email = "romao@gmail.com"
        )

        usuarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios
            .stream()
            .filter { u -> u.id == id }
            .findFirst()
            .get()
    }

}
