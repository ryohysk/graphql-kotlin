package com.ryohysk.graphqlkotlin.domain.model

data class Product(
        val id: Long,
        val name: String,
        val price: Long,
        val categoryId: Long
)