package com.romoura.forum.service

import com.romoura.forum.domain.Usuario
import com.romoura.forum.exceptions.ForumNotFoundException
import com.romoura.forum.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) : UserDetailsService {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }

    override fun loadUserByUsername(email: String?): UserDetails {
        val usuario = repository.findByEmail(email) ?: throw ForumNotFoundException("Email não encontrado.")
        return UserDetail(usuario)
    }

}
