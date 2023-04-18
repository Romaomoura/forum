package com.romoura.forum.domain

import com.romoura.forum.domain.enums.StatusTopico
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity(name = "topico")
data class Topico(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    var titulo: String = "",
    var mensagem: String = "",
    val criadoEm: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val curso: Curso? = null,

    @ManyToOne
    val autor: Usuario? = null,

    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Topico

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , titulo = $titulo , mensagem = $mensagem , criadoEm = $criadoEm , curso = $curso , autor = $autor , status = $status )"
    }
}