package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.Product

interface ProductService {
    fun findAll(categoryId: Long?): List<Product>
}