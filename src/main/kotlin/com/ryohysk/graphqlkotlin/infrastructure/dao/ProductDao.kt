package com.ryohysk.graphqlkotlin.infrastructure.dao

import com.ryohysk.graphqlkotlin.infrastructure.entity.FavoriteProductEntity
import com.ryohysk.graphqlkotlin.infrastructure.entity.ProductEntity
import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable
import java.util.stream.Collector

@Dao
@ConfigAutowireable
interface ProductDao {
    @Select
    fun findAll(categoryId: Long?): List<ProductEntity>

    @Select(strategy = SelectType.COLLECT)
    fun <R> findFavoriteProducts(userIds: List<Long>, collector: Collector<FavoriteProductEntity, *, R>): R
}