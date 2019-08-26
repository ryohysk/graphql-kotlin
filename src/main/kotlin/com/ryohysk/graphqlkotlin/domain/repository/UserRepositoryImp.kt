package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImp : UserRepository {
    override fun findUsers() = listOf(
            User(1, "Mark"),
            User(2, "Tom"),
            User(3, "John"),
            User(4, "Ryo")
    )
}