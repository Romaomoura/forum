package com.romoura.forum.service

import com.romoura.forum.domain.Usuario
import com.romoura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }

}
