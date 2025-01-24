package net.elau.example.spring_data_jpa.repository

import net.elau.example.spring_data_jpa.model.Owner
import net.elau.example.spring_data_jpa.repository.filter.FindOwnerFilter

interface OwnerRepositoryCustom {

    fun findByFilter(findOwnerFilter: FindOwnerFilter): List<Owner>
}