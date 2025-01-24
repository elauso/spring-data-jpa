package net.elau.example.spring_data_jpa.repository.filter

import java.math.BigDecimal

data class FindProductFilter(
    val name: String?,
    val description: String?,
    val ownerName: String?,
    val ownerEmail: String?
)
