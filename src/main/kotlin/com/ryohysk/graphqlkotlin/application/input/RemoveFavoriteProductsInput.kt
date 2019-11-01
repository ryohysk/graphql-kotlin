package com.ryohysk.graphqlkotlin.application.input

data class RemoveFavoriteProductsInput(
        val userId: Long,
        val productIds: List<Long>
)