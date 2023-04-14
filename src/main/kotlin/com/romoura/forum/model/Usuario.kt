package com.romoura.forum.model

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity(name = "usuario")
@NoArgsConstructor
data class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    val nome: String,
    val email: String
)
