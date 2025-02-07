package net.elau.example.spring_data_jpa.repository

import net.elau.example.spring_data_jpa.model.Product
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product, Int>, ProductRepositoryCustom {

    @Query("SELECT p FROM Product p WHERE p.name like %:name%")
    fun findByName(name: String): List<Product>

    @EntityGraph(attributePaths = ["owner"])
    @Query("SELECT p FROM Product p WHERE p.description like %:description%")
//    @Query("SELECT p FROM Product p JOIN FETCH p.owner WHERE p.description like %:description%")
    fun findByDescription(description: String): List<Product>
}