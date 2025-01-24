package net.elau.example.spring_data_jpa.mapper

import net.elau.example.spring_data_jpa.dto.ProductDto
import net.elau.example.spring_data_jpa.model.Product
import net.elau.example.spring_data_jpa.repository.filter.FindProductFilter
import net.elau.example.spring_data_jpa.web.request.ProductFilterRequestParams
import net.elau.example.spring_data_jpa.web.response.ProductResponse

fun ProductFilterRequestParams.toDto() = FindProductFilter(
    name = name,
    description = description,
    ownerName = ownerName,
    ownerEmail = ownerEmail
)

fun Product.toDto() = ProductDto(
    id = id!!,
    name = name,
    description = description,
    price = price,
    createdAt = createdAt,
    owner = owner.toDto()
)

fun ProductDto.toResponse() = ProductResponse(
    id = id,
    name = name,
    description = description,
    price = price,
    createdAt = createdAt,
    owner = owner.toResponse()
)