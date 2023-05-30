package com.romoura.forum.domain

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Teste Topico",
        mensagem = "Testando metodos da classe topico.",
        aplicacao = AplicacaoTest.build(),
        autor = UsuarioTest.build()
    )
}