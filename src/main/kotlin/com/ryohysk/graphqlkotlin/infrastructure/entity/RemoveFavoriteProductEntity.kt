package com.ryohysk.graphqlkotlin.infrastructure.entity

import org.seasar.doma.*
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "users_favorite_products")
data class RemoveFavoriteProductEntity(
        @Id
        val userId: Long,
        @Id
        val productId: Long
)