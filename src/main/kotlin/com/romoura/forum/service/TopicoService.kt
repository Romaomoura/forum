package com.romoura.forum.service

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.dto.TopicoUpdateInput
import com.romoura.forum.exceptions.ForumNotFoundException
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
            .orElseThrow{ForumNotFoundException("Topico de id: ${id} não encontrado.")}

        return outputMapper.map(t)
    }

    fun cadastrar(t: TopicoInput): TopicoOutput {
        val topico = inputMapper.map(t)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return outputMapper.map(topico)
    }

    fun atualizar(id: Long, input: TopicoUpdateInput):TopicoOutput {
        val topico = topicos
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow{ForumNotFoundException("Topico de id: ${id} não encontrado.")}
        val topicoAtualizado = Topico(
            id = id,
            titulo = input.titulo,
            mensagem = input.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            criadoEm = topico.criadoEm,
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return outputMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow{ForumNotFoundException("Topico de id: ${id} não encontrado.")}
        topicos = topicos.minus(topico)
    }

}