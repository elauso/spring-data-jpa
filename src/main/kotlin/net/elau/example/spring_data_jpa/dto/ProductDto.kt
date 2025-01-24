package net.elau.example.spring_data_jpa.dto

import java.math.BigDecimal
import java.time.Instant

data class ProductDto(
    val id: Int,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val createdAt: Instant,
    val owner: OwnerDto
)
