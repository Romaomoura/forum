package com.romoura.forum.service

import com.romoura.forum.domain.TopicoOutputTest
import com.romoura.forum.domain.TopicoTest
import com.romoura.forum.exceptions.ForumNotFoundException
import com.romoura.forum.mapper.TopicoInputMapper
import com.romoura.forum.mapper.TopicoOutputMapper
import com.romoura.forum.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicoServiceTest {

    val topicos = PageImpl(listOf(TopicoTest.build()))

    val paginacao: Pageable = mockk()

    val topicoRepository: TopicoRepository = mockk {
        every { findByAplicacaoNome(any(), any()) } returns topicos
        every { findAll(paginacao) } returns topicos
    }

    val outputMapper: TopicoOutputMapper = mockk {
        every { map(any()) } returns TopicoOutputTest.build()
    }
    val inputMapper: TopicoInputMapper = mockk()


    val topicoService = TopicoService(
        topicoRepository, outputMapper, inputMapper
    )

    @Test
    fun `deve listar topicos a partir do nome da aplicacao`() {

        topicoService.listar("Avante", paginacao)

        verify(exactly = 1) { topicoRepository.findByAplicacaoNome(any(), any()) }
        verify(exactly = 1) { outputMapper.map(any()) }
        verify(exactly = 0) { topicoRepository.findAll(paginacao) }
    }

    @Test
    fun `deve listar todos os topicos quando o nome da aplicacao for nula`(){
        topicoService.listar(null, paginacao)

        verify(exactly = 0) { topicoRepository.findByAplicacaoNome(any(), any()) }
        verify(exactly = 1) { outputMapper.map(any()) }
        verify(exactly = 1) { topicoRepository.findAll(paginacao) }
    }

    @Test
    fun `deve listar not found exception quando topico nao for encontrado`(){
        every { topicoRepository.findById(any()) } returns Optional.empty()

        val atual = assertThrows<ForumNotFoundException> {
            topicoService.buscarPorId(1)
        }

        assertThat(atual.message).isEqualTo("Topico de id: 1 não encontrado.")

    }

}