package com.romoura.forum.repository

import com.romoura.forum.domain.Topico
import com.romoura.forum.dto.TopicoPorCategoriaOutput
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findByAplicacaoNome(nomeAplicacao: String, p: Pageable): Page<Topico>

    @Query(
        "SELECT new com.romoura.forum.dto.TopicoPorCategoriaOutput(c.categoria, count(t)) " +
                "FROM topico t " +
                "JOIN t.aplicacao c " +
                "GROUP BY c.categoria"
    )
    fun relatorio(): List<TopicoPorCategoriaOutput>

}