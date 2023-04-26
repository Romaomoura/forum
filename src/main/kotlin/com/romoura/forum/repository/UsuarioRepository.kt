package com.romoura.forum.repository

import com.romoura.forum.domain.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByEmail(email: String?): Usuario?

}