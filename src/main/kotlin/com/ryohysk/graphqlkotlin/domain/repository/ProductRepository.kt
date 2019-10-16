package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.Product

interface ProductRepository {
    fun findAll(categoryId: Long?): List<Product>
}