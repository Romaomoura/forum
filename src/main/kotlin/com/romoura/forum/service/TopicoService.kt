package com.romoura.forum.service

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.dto.TopicoUpdateInput
import com.romoura.forum.exceptions.ForumNotFoundException
import com.romoura.forum.mapper.TopicoInputMapper
import com.romoura.forum.mapper.TopicoOutputMapper
import com.romoura.forum.model.Topico
import com.romoura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val outputMapper: TopicoOutputMapper,
    private val inputMapper: TopicoInputMapper
) {

    fun listar(): List<TopicoOutput> {
        return repository.findAll().stream().map { t ->
            outputMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoOutput {
        val t = repository.findById(id)
            .orElseThrow{ForumNotFoundException("Topico de id: ${id} não encontrado.")}

        return outputMapper.map(t)
    }

    fun cadastrar(t: TopicoInput): TopicoOutput {

        val topico = inputMapper.map(t)
        repository.save(topico)

        return outputMapper.map(topico)
    }

    fun atualizar(id: Long, input: TopicoUpdateInput):TopicoOutput {

        val topico = repository.findById(id)
            .orElseThrow{ForumNotFoundException("Topico de id: ${id} não encontrado.")}

        topico.copy(
            titulo = input.titulo,
            mensagem = input.mensagem,
        )

        repository.save(topico)

        return outputMapper.map(topico)
    }

    fun deletar(id: Long) {
        val topico = repository.findById(id)
            .orElseThrow{ForumNotFoundException("Topico de id: ${id} não encontrado.")}
        repository.delete(topico)
    }

}