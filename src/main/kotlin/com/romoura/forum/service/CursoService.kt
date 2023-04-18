package com.romoura.forum.service

import com.romoura.forum.domain.Curso
import com.romoura.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val repository: CursoRepository
) {

    fun buscarPorId(id: Long): Curso {
        return repository.getReferenceById(id)
    }

}