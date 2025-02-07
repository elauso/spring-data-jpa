package net.elau.example.spring_data_jpa.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.criteria.Join
import jakarta.persistence.criteria.JoinType
import jakarta.persistence.criteria.Predicate
import net.elau.example.spring_data_jpa.model.Owner
import net.elau.example.spring_data_jpa.model.Product
import net.elau.example.spring_data_jpa.repository.filter.FindProductFilter

class ProductRepositoryCustomImpl : ProductRepositoryCustom {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findByFilter(findProductFilter: FindProductFilter): List<Product> {
        val cb = entityManager.criteriaBuilder

        val query = cb.createQuery(Product::class.java)
        val product = query.from(Product::class.java)
        val productOwner: Join<Product, Owner> = product.join("owner", JoinType.INNER)

        val predicates = mutableListOf<Predicate>()

        if (findProductFilter.name != null) {
            predicates.add(cb.like(product.get("name"), "%${findProductFilter.name}%"))
        }

        if (findProductFilter.description != null) {
            predicates.add(cb.like(product.get("description"), "%${findProductFilter.description}%"))
        }

        if (findProductFilter.ownerName != null) {
            predicates.add(cb.like(productOwner.get("name"), "%${findProductFilter.ownerName}%"))
        }

        if (findProductFilter.ownerEmail != null) {
            predicates.add(cb.like(productOwner.get("email"), "%${findProductFilter.ownerEmail}%"))
        }

        query.select(product).where(cb.and(*predicates.toTypedArray()))

        val fetchGraph = entityManager.createEntityGraph(Product::class.java)
        fetchGraph.addSubgraph<Owner>("owner")

        return entityManager.createQuery(query)
            .setHint("javax.persistence.loadgraph", fetchGraph).resultList
    }
}
