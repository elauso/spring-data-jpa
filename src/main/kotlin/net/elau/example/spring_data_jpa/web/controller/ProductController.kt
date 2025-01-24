package net.elau.example.spring_data_jpa.web.controller

import net.elau.example.spring_data_jpa.mapper.toDto
import net.elau.example.spring_data_jpa.mapper.toResponse
import net.elau.example.spring_data_jpa.service.ProductService
import net.elau.example.spring_data_jpa.web.request.ProductFilterRequestParams
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun findByFilter(filterParams: ProductFilterRequestParams) =
        service.findByFilter(filterParams.toDto()).map { it.toResponse() }
}
