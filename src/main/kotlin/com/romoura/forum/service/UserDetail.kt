package com.romoura.forum.service

import com.romoura.forum.domain.Usuario
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val usuario: Usuario
) : UserDetails {
    override fun getAuthorities() = usuario.role

    override fun getPassword() = usuario.senha

    override fun getUsername() = usuario.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}