package com.ryohysk.graphqlkotlin.application.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.ryohysk.graphqlkotlin.domain.service.ProductService
import org.springframework.stereotype.Component

@Component
class ProductQueryResolver(private val productService: ProductService) : GraphQLQueryResolver {
    fun products(categoryId: Long?) = productService.findAll(categoryId)
}