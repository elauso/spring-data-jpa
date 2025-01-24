package net.elau.example.spring_data_jpa.web.request

import org.springframework.web.bind.annotation.RequestParam

data class ProductFilterRequestParams(

    @RequestParam(required = false)
    val name: String? = null,

    @RequestParam(required = false)
    val description: String? = null,

    @RequestParam(required = false)
    val ownerName: String? = null,

    @RequestParam(required = false)
    val ownerEmail: String? = null,
)
