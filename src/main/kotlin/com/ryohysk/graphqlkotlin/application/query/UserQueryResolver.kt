package com.ryohysk.graphqlkotlin.application.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.ryohysk.graphqlkotlin.domain.service.UserService
import org.springframework.stereotype.Component

@Component
class UserQueryResolver(private val userService: UserService) : GraphQLQueryResolver {
    @Suppress("unused")
    fun users(id: Long?) = userService.findUsersBy(id)
}