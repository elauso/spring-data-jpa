package net.elau.example.spring_data_jpa.dto

import java.time.Instant

data class OwnerDto(
    val id: Int,
    val name: String,
    val email: String,
    val createdAt: Instant
)
