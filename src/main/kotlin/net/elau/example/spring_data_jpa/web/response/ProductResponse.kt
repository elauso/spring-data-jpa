package net.elau.example.spring_data_jpa.web.response

import java.math.BigDecimal
import java.time.Instant

data class ProductResponse(
    val id: Int,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val createdAt: Instant,
    val owner: OwnerResponse
)
