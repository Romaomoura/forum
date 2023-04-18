package com.romoura.forum.domain

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity
data class Resposta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    val mensagem: String? = "",
    val criadoEm: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val autor: Usuario? = null,

    @ManyToOne
    val topico: Topico? = null,

    val solucao: Boolean? = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Resposta

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , mensagem = $mensagem , criadoEm = $criadoEm , autor = $autor , topico = $topico , solucao = $solucao )"
    }
}
