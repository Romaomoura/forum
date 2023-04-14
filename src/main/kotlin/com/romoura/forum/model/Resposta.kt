package com.romoura.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Resposta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    val mensagem: String,
    val criadoEm: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val autor: Usuario,

    @ManyToOne
    val topico: Topico,

    val solucao: Boolean
)
