package com.romoura.forum.integration

import com.romoura.forum.domain.TopicoTest
import com.romoura.forum.dto.TopicoPorCategoriaOutput
import com.romoura.forum.repository.TopicoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest {

    @Autowired
    private lateinit var topicoRepository: TopicoRepository

    private val paginacao = PageRequest.of(0, 5)
    private val topico = TopicoTest.build()

    companion object {
        @Container
        private val pssqlContainer = PostgreSQLContainer("postgres:14.0-alpine").apply {
            withDatabaseName("dbTeste")
            withUsername("romoura")
            withPassword("1807")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", pssqlContainer::getJdbcUrl)
            registry.add("spring.datasource.username", pssqlContainer::getUsername)
            registry.add("spring.datasource.password", pssqlContainer::getPassword)
        }
    }

    @Test
    fun `deve gerar um relatorio`() {
        topicoRepository.save(topico)
        val relatorio = topicoRepository.relatorio()

        assertThat(relatorio).isNotNull
        assertThat(relatorio.first()).isExactlyInstanceOf(TopicoPorCategoriaOutput::class.java)
    }

    @Test
    fun `deve buscar um topico por nome`() {
        topicoRepository.save(topico)
        val resultado = topicoRepository.findByAplicacaoNome(nomeAplicacao = "Avante", p = paginacao)

        assertThat(resultado.totalElements).isEqualTo(1)
    }
}