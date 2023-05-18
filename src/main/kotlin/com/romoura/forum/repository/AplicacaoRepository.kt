package com.romoura.forum.repository

import com.romoura.forum.domain.Aplicacao
import org.springframework.data.jpa.repository.JpaRepository

interface AplicacaoRepository : JpaRepository<Aplicacao, Long> {
}