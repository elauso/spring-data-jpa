package net.elau.example.spring_data_jpa.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.criteria.Predicate
import net.elau.example.spring_data_jpa.model.Owner
import net.elau.example.spring_data_jpa.repository.filter.FindOwnerFilter

class OwnerRepositoryCustomImpl : OwnerRepositoryCustom {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findByFilter(findOwnerFilter: FindOwnerFilter): List<Owner> {
        val cb = entityManager.criteriaBuilder

        val query = cb.createQuery(Owner::class.java)
        val owner = query.from(Owner::class.java)

        val predicates = mutableListOf<Predicate>()

        if (findOwnerFilter.name != null) {
            predicates.add(cb.like(owner.get("name"), "%${findOwnerFilter.name}%"))
        }

        if (findOwnerFilter.email != null) {
            predicates.add(cb.like(owner.get("email"), "%${findOwnerFilter.email}%"))
        }

        query.select(owner).where(cb.and(*predicates.toTypedArray()))
        return entityManager.createQuery(query).resultList
    }
}
