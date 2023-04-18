package com.romoura.forum.domain

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity(name = "usuario")
data class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    val nome: String? = "",
    val email: String? = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Usuario

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , nome = $nome , email = $email )"
    }
}
