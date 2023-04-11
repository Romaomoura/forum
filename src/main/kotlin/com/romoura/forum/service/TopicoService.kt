package com.romoura.forum.service

import com.romoura.forum.model.Curso
import com.romoura.forum.model.Topico
import com.romoura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico>
) {

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Romão",
                email = "romao@gmail.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Duvida Java",
            mensagem = "Java",
            curso = Curso(
                id = 2,
                nome = "Java",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 2,
                nome = "Moura",
                email = "moura@gmail.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Duvida .NET",
            mensagem = ".NET",
            curso = Curso(
                id = 3,
                nome = ".NET",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 3,
                nome = "Amanda moura",
                email = "amanda@gmail.com"
            )
        )

        topicos = listOf(topico1, topico2, topico3)
    }

    fun listar(): List<Topico> {

        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t -> t.id == id }.findFirst().get()
    }

}