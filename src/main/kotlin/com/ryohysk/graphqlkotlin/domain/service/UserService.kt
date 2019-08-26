package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.User

interface UserService {
    fun findUsersBy(id: Int?): List<User>
}