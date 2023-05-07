package com.romoura.forum.dto

import com.romoura.forum.domain.enums.StatusTopico
import java.time.LocalDateTime

data class TopicoOutput(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val criadoEm: LocalDateTime
)
