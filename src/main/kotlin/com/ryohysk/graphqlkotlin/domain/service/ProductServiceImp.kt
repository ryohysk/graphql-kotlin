package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.Product
import com.ryohysk.graphqlkotlin.domain.model.User
import com.ryohysk.graphqlkotlin.domain.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductServiceImp(private val productRepository: ProductRepository) : ProductService {
    override fun findAll(categoryId: Long?) = productRepository.findAll(categoryId)

    override fun findFavoriteProducts(users: List<User>): List<List<Product>> {
        val favoriteProducts = productRepository.findFavoriteProducts(users.map { it.id })
        return users.parallelStream().map { favoriteProducts[it.id] ?: listOf() }.collect(Collectors.toList<List<Product>>())
    }

    override fun addFavoriteProducts(userId: Long, productIds: List<Long>) {
        productRepository.addFavoriteProducts(userId, productIds)
    }
}