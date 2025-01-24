package net.elau.example.spring_data_jpa.web.controller

import net.elau.example.spring_data_jpa.mapper.toResponse
import net.elau.example.spring_data_jpa.repository.filter.FindOwnerFilter
import net.elau.example.spring_data_jpa.service.OwnerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/owners")
class OwnerController(private val service: OwnerService) {

    @GetMapping
    fun findByFilter(
        @RequestParam(required = false) name: String? = null,
        @RequestParam(required = false) email: String? = null
    ) =
        service.findByFilter(FindOwnerFilter(name, email)).map { it.toResponse() }
}