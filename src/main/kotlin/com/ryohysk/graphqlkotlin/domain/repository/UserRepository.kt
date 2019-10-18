package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.User

interface UserRepository {
    fun findUsers(id: Long?): List<User>
}