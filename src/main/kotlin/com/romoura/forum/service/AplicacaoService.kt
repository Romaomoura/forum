package com.romoura.forum.service

import com.romoura.forum.domain.Aplicacao
import com.romoura.forum.repository.AplicacaoRepository
import org.springframework.stereotype.Service

@Service
class AplicacaoService(
    private val repository: AplicacaoRepository
) {

    fun buscarPorId(id: Long): Aplicacao {
        return repository.getOne(id)
    }

}