package net.elau.example.spring_data_jpa.service

import net.elau.example.spring_data_jpa.mapper.toDto
import net.elau.example.spring_data_jpa.repository.ProductRepository
import net.elau.example.spring_data_jpa.repository.filter.FindProductFilter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProductService(private val repository: ProductRepository) {

    fun findByFilter(findProductFilter: FindProductFilter) =
        repository.findByFilter(findProductFilter).map { it.toDto() }
}
