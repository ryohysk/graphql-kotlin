package com.ryohysk.graphqlkotlin.application.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.ryohysk.graphqlkotlin.application.input.AddFavoriteProductsInput
import com.ryohysk.graphqlkotlin.domain.service.ProductService
import org.springframework.stereotype.Component

@Component
class UserMutationResolver(private val productService: ProductService) : GraphQLMutationResolver {
    @Suppress("unused")
    fun addFavoriteProducts(input: AddFavoriteProductsInput): Boolean {
        productService.addFavoriteProducts(input.userId, input.productIds)
        return true
    }
}