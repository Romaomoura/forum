package com.romoura.forum.service

import com.romoura.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(
    var cusros: List<Curso>
) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        cusros = listOf(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cusros.stream()
            .filter { c -> c.id == id }
            .findFirst().get()
    }

}