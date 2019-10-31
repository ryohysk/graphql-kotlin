package com.ryohysk.graphqlkotlin.infrastructure.entity

import org.seasar.doma.Entity
import org.seasar.doma.Table
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "users_favorite_products")
data class AddFavoriteProductEntity(
        val userId: Long,
        val productId: Long
)