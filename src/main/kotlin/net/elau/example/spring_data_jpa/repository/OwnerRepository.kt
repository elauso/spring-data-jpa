package net.elau.example.spring_data_jpa.repository

import net.elau.example.spring_data_jpa.model.Owner
import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<Owner, Int>, OwnerRepositoryCustom {
}