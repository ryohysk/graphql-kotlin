package com.ryohysk.graphqlkotlin.infrastructure.entity

import org.seasar.doma.Entity
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
data class UserEntity(
        val id: Long,
        val name: String
)