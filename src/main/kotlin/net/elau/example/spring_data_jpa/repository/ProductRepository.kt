package net.elau.example.spring_data_jpa.repository

import net.elau.example.spring_data_jpa.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int>, ProductRepositoryCustom {
}