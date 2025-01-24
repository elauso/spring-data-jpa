package net.elau.example.spring_data_jpa.model

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "owner")
class Owner(

    @Column(name = "name", nullable = false, updatable = false)
    val name: String,

    @Column(name = "email", nullable = false, updatable = false)
    val email: String,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Int? = null,
)