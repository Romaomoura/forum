package com.romoura.forum.model

import jakarta.persistence.*
import lombok.NoArgsConstructor


@Entity(name = "curso")
@NoArgsConstructor
data class Curso(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    val nome: String,
    val categoria: String
)
