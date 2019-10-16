package com.ryohysk.graphqlkotlin.infrastructure.dao

import com.ryohysk.graphqlkotlin.infrastructure.entity.ProductEntity
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable

@Dao
@ConfigAutowireable
interface ProductDao {
    @Select
    fun findAll(categoryId: Long?): List<ProductEntity>
}