package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.Product
import com.ryohysk.graphqlkotlin.infrastructure.dao.ProductDao
import com.ryohysk.graphqlkotlin.infrastructure.entity.ProductEntity
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImp(private val productDao: ProductDao) : ProductRepository {
    override fun findAll(categoryId: Long?) =
            productDao.findAll(categoryId).map { it.convertIntoProduct() }

    private fun ProductEntity.convertIntoProduct() = Product(
            id = id,
            name = name,
            price = price,
            categoryId = categoryId
    )
}