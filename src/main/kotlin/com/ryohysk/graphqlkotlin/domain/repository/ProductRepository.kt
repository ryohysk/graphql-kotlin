package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.Product

interface ProductRepository {
    fun findAll(categoryId: Long?): List<Product>
    fun findFavoriteProducts(userIds: List<Long>): Map<Long, List<Product>>
    fun addFavoriteProducts(userId: Long, productIds: List<Long>)
    fun removeFavoriteProducts(userId: Long, productIds: List<Long>)
}