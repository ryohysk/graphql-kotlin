package com.ryohysk.graphqlkotlin.infrastructure.dao

import com.ryohysk.graphqlkotlin.infrastructure.entity.UserEntity
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable

@Dao
@ConfigAutowireable
interface UserDao {
    @Select
    fun findUsers(id: Long?): List<UserEntity>
}