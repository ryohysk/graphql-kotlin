package com.ryohysk.graphqlkotlin.domain.repository

import com.ryohysk.graphqlkotlin.domain.model.User
import com.ryohysk.graphqlkotlin.infrastructure.dao.UserDao
import com.ryohysk.graphqlkotlin.infrastructure.entity.UserEntity
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImp(private val userDao: UserDao) : UserRepository {
    override fun findUsers(id: Long?) = userDao.findUsers(id).map { it.convertIntoUser() }

    private fun UserEntity.convertIntoUser() = User(
            id = id,
            name = name
    )
}