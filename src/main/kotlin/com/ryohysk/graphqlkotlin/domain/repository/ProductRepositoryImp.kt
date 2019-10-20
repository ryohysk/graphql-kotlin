package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.Product
import com.ryohysk.graphqlkotlin.infrastructure.dao.ProductDao
import com.ryohysk.graphqlkotlin.infrastructure.entity.FavoriteProductEntity
import com.ryohysk.graphqlkotlin.infrastructure.entity.ProductEntity
import org.springframework.stereotype.Repository
import java.util.stream.Collectors

@Repository
class ProductRepositoryImp(private val productDao: ProductDao) : ProductRepository {
    override fun findAll(categoryId: Long?) =
            productDao.findAll(categoryId).map { it.convertIntoProduct() }

    override fun findFavoriteProducts(userIds: List<Long>) =
            productDao.findFavoriteProducts(userIds, Collectors.groupingBy(FavoriteProductEntity::userId)).mapValues {
                it.value.map { favoriteProductEntity ->
                    favoriteProductEntity.convertIntoProduct()
                }
            }

    private fun ProductEntity.convertIntoProduct() = Product(
            id = id,
            name = name,
            price = price,
            categoryId = categoryId
    )

    private fun FavoriteProductEntity.convertIntoProduct() = Product(
            id = productId,
            name = name,
            price = price,
            categoryId = categoryId
    )
}