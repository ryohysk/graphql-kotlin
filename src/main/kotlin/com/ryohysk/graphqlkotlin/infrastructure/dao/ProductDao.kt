package com.ryohysk.graphqlkotlin.infrastructure.dao

import com.ryohysk.graphqlkotlin.infrastructure.entity.*
import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.BatchResult
import java.util.stream.Collector

@Dao
@ConfigAutowireable
interface ProductDao {
    @Select
    fun findAll(categoryId: Long?): List<ProductEntity>

    @Select(strategy = SelectType.COLLECT)
    fun <R> findFavoriteProducts(userIds: List<Long>, collector: Collector<FavoriteProductEntity, *, R>): R

    @BatchInsert
    fun addFavoriteProducts(addFavoriteProductEntity: List<AddFavoriteProductEntity>): BatchResult<AddFavoriteProductEntity>

    @BatchDelete
    fun removeFavoriteProducts(addFavoriteProductEntity: List<RemoveFavoriteProductEntity>): BatchResult<RemoveFavoriteProductEntity>
}