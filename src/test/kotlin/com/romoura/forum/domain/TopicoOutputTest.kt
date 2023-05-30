package com.romoura.forum.domain

import com.romoura.forum.domain.enums.StatusTopico
import com.romoura.forum.dto.TopicoOutput
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoOutputTest {
    fun build() = TopicoOutput(
        id = 1,
        titulo = "Teste Topico",
        mensagem = "Testando metodos da classe topico.",
        status = StatusTopico.NAO_RESPONDIDO,
        criadoEm = LocalDateTime.now(),
        dataAlteracao = LocalDateTime.now(),
    )
}