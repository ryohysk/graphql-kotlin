package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.User
import com.ryohysk.graphqlkotlin.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImp(private val userRepository: UserRepository) : UserService {
    /**
     * ユーザー取得処理(idがnullで全件取得)
     */
    override fun findUsersBy(id: Long?): List<User> {
        val users = userRepository.findUsers(id)
        return when (id) {
            is Long -> users.find { it.id == id }?.run { listOf(this) } ?: listOf()
            else -> users
        }
    }
}