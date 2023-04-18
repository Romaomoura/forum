package com.romoura.forum.repository

import com.romoura.forum.domain.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
}