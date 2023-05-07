package com.romoura.forum.repository

import com.romoura.forum.domain.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}