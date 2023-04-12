package com.romoura.forum.service

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.mapper.TopicoInputMapper
import com.romoura.forum.mapper.TopicoOutputMapper
import com.romoura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val outputMapper: TopicoOutputMapper,
    private val inputMapper: TopicoInputMapper
) {

    fun listar(): List<TopicoOutput> {
        return topicos.stream().map { t ->
            outputMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoOutput {
        val t = topicos
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .get()

        return outputMapper.map(t)
    }

    fun cadastrar(t: TopicoInput) {
        val topico = inputMapper.map(t)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

}