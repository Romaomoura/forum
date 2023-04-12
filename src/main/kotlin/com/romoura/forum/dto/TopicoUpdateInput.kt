package com.romoura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoUpdateInput(

    @field:NotNull
    val id: Long,

    @field:NotEmpty(message = "Campo titulo não pode ser vazio")
    @field:Size(min = 5, max = 100, message = "O campo titulo precisa de no minimo 5 caracteres")
    val titulo: String,

    @field:NotEmpty(message = "Campo mensagem não pode ser vazio")
    val mensagem: String
)
