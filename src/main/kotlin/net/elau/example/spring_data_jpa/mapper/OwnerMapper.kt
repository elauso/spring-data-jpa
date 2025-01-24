package net.elau.example.spring_data_jpa.mapper

import net.elau.example.spring_data_jpa.dto.OwnerDto
import net.elau.example.spring_data_jpa.model.Owner
import net.elau.example.spring_data_jpa.web.response.OwnerResponse

fun Owner.toDto() = OwnerDto(
    id = id!!,
    name = name,
    email = email,
    createdAt = createdAt
)

fun OwnerDto.toResponse() = OwnerResponse(
    id = id,
    name = name,
    email = email,
    createdAt = createdAt
)