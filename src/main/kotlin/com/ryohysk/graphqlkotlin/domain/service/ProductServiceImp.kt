package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImp(private val productRepository: ProductRepository) : ProductService {
    override fun findAll(categoryId: Long?) = productRepository.findAll(categoryId)
}