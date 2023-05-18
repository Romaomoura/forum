package com.romoura.forum.service

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.dto.TopicoPorCategoriaOutput
import com.romoura.forum.dto.TopicoUpdateInput
import com.romoura.forum.exceptions.ForumNotFoundException
import com.romoura.forum.mapper.TopicoInputMapper
import com.romoura.forum.mapper.TopicoOutputMapper
import com.romoura.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val outputMapper: TopicoOutputMapper,
    private val inputMapper: TopicoInputMapper
) {

    fun listar(
        nomeAplicacao: String?,
        p: Pageable
    ): Page<TopicoOutput> {

        val topicos = if (nomeAplicacao == null) {
            repository.findAll(p)
        } else {
            repository.findByAplicacaoNome(nomeAplicacao, p)
        }
        return topicos.map { t ->
            outputMapper.map(t)
        }

    }

    fun buscarPorId(id: Long): TopicoOutput {
        val t = repository.findById(id)
            .orElseThrow { ForumNotFoundException("Topico de id: ${id} não encontrado.") }

        return outputMapper.map(t)
    }

    fun cadastrar(t: TopicoInput): TopicoOutput {

        val topico = inputMapper.map(t)
        repository.save(topico)

        return outputMapper.map(topico)
    }

    fun atualizar(id: Long, input: TopicoUpdateInput): TopicoOutput {

        val topico = repository.findById(id)
            .orElseThrow { ForumNotFoundException("Topico de id: ${id} não encontrado.") }


        topico.titulo = input.titulo
        topico.mensagem = input.mensagem
        topico.dataAlteracao = LocalDateTime.now()

        return outputMapper.map(topico)
    }

    fun deletar(id: Long) {

        repository.findById(id)
            .orElseThrow { ForumNotFoundException("Topico de id: ${id} não encontrado.") }

        repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaOutput> {
        return repository.relatorio()
    }

}