package com.romoura.forum.mapper

import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoOutputMapper: Mapper<Topico, TopicoOutput> {

    override fun map(t: Topico): TopicoOutput {
        return TopicoOutput(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            criadoEm = t.criadoEm
        )
    }

}