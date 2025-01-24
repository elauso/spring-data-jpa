package net.elau.example.spring_data_jpa.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "product")
class Product(

    @Column(name = "name", nullable = false, updatable = false)
    val name: String,

    @Column(name = "description", updatable = false)
    val description: String,

    @Column(name = "price", updatable = false)
    val price: BigDecimal,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    val owner: Owner,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Int? = null,
)
