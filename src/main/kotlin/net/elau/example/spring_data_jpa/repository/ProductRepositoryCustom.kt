package net.elau.example.spring_data_jpa.repository

import net.elau.example.spring_data_jpa.model.Product
import net.elau.example.spring_data_jpa.repository.filter.FindProductFilter

interface ProductRepositoryCustom {

    fun findByFilter(findProductFilter: FindProductFilter): List<Product>
}