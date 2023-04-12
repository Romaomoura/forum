package com.romoura.forum.mapper

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.model.Topico
import com.romoura.forum.service.CursoService
import com.romoura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoInputMapper(
    private val cursoService: CursoService,
    private val autorService: UsuarioService
) : Mapper<TopicoInput, Topico> {
    override fun map(t: TopicoInput): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = autorService.buscarPorId(t.idAutor)
        )
    }
}
