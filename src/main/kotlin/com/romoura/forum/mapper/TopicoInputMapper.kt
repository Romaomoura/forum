package com.romoura.forum.mapper

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.domain.Topico
import com.romoura.forum.service.AplicacaoService
import com.romoura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoInputMapper(
    private val aplicacaoervice: AplicacaoService,
    private val autorService: UsuarioService
) : Mapper<TopicoInput, Topico> {
    override fun map(t: TopicoInput): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            aplicacao = aplicacaoervice.buscarPorId(t.idAplicacao),
            autor = autorService.buscarPorId(t.idAutor)
        )
    }
}
