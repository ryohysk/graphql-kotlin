package com.ryohysk.graphqlkotlin.application.input

data class AddFavoriteProductsInput(
        val userId: Long,
        val productIds: List<Long>
)