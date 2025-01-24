package net.elau.example.spring_data_jpa.service

import net.elau.example.spring_data_jpa.mapper.toDto
import net.elau.example.spring_data_jpa.repository.OwnerRepository
import net.elau.example.spring_data_jpa.repository.filter.FindOwnerFilter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OwnerService(private val repository: OwnerRepository) {

    fun findByFilter(findOwnerFilter: FindOwnerFilter) =
        repository.findByFilter(findOwnerFilter).map { it.toDto() }
}