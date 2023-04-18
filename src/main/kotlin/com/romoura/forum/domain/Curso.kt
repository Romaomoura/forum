package com.romoura.forum.domain

import jakarta.persistence.*
import org.hibernate.Hibernate


@Entity(name = "curso")
data class Curso(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    val nome: String? = "",
    val categoria: String? = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Curso

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , nome = $nome , categoria = $categoria )"
    }
}
