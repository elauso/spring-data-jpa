package net.elau.example.spring_data_jpa.web.controller

import net.elau.example.spring_data_jpa.mapper.toDto
import net.elau.example.spring_data_jpa.mapper.toResponse
import net.elau.example.spring_data_jpa.service.ProductService
import net.elau.example.spring_data_jpa.web.request.ProductFilterRequestParams
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {

    @GetMapping("/find-by-filter")
    fun findByFilter(filterParams: ProductFilterRequestParams) =
        service.findByFilter(filterParams.toDto()).map { it.toResponse() }

    @GetMapping("/find-by-name")
    fun findByName(@RequestParam name: String) =
        service.findByName(name).map { it.toResponse() }

    @GetMapping("/find-by-description")
    fun findByDescription(@RequestParam description: String) =
        service.findByDescription(description).map { it.toResponse() }
}
