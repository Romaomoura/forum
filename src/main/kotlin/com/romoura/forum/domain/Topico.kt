package com.romoura.forum.domain

import com.romoura.forum.domain.enums.StatusTopico
import org.hibernate.Hibernate
import java.time.LocalDateTime
import javax.persistence.*

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
    val aplicacao: Aplicacao? = null,

    @ManyToOne
    val autor: Usuario? = null,

    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList(),

    var dataAlteracao: LocalDateTime? = null
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
        return this::class.simpleName + "(id = $id , titulo = $titulo , mensagem = $mensagem , criadoEm = $criadoEm , aplicacao = $aplicacao , autor = $autor , status = $status )"
    }
}