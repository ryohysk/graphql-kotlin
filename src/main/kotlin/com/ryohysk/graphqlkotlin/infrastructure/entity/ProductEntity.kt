package com.ryohysk.graphqlkotlin.infrastructure.entity

import org.seasar.doma.Entity
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
data class ProductEntity(
        val id: Long,
        val name: String,
        val price: Long,
        val categoryId: Long
)