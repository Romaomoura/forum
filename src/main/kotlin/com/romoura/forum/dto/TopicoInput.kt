package com.romoura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoInput(
    @field:NotEmpty(message = "Campo titulo não pode está vazio.")
    @field:Size(min=5, max = 100, message = "O campo titulo precisa de no minimo 5 caracteres")
    val titulo: String,
    @field:NotEmpty(message = "Campo mensagem não pode está vazio.")
    @field:Size(min=5, max = 100, message = "O campo mensagem precisa de no minimo 5 caracteres")
    val mensagem: String,
    @field:NotNull(message = "O campo curso não pode ser nulo ou vazio")
    val idCurso: Long,
    @field:NotNull(message = "O campo autor não pode ser nulo ou vazio")
    val idAutor: Long
)





