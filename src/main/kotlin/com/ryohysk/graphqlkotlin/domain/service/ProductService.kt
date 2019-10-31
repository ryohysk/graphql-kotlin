package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.Product
import com.ryohysk.graphqlkotlin.domain.model.User

interface ProductService {
    fun findAll(categoryId: Long?): List<Product>
    fun findFavoriteProducts(users: List<User>): List<List<Product>>
    fun addFavoriteProducts(userId: Long, productIds: List<Long>)
}