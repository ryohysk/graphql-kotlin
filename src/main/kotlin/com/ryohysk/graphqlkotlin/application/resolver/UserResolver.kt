package com.ryohysk.graphqlkotlin.application.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.ryohysk.graphqlkotlin.domain.enumeration.DataLoaderKey
import com.ryohysk.graphqlkotlin.domain.model.Product
import com.ryohysk.graphqlkotlin.domain.model.User
import graphql.schema.DataFetchingEnvironment
import graphql.servlet.context.GraphQLContext
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class UserResolver : GraphQLResolver<User> {
    fun favoriteProducts(user: User, dfe: DataFetchingEnvironment): CompletableFuture<List<Product>> {
        return dfe.getContext<GraphQLContext>().dataLoaderRegistry.get()
                .getDataLoader<User, List<Product>>(DataLoaderKey.FAVORITE_PRODUCTS.name).load(user)
    }
//    fun points(user: User, dfe: DataFetchingEnvironment): CompletableFuture<Int> {
//        return dfe.getContext<GraphQLContext>().dataLoaderRegistry.get()
//                .getDataLoader<User, Int>(DataLoaderKey.USERS_POINTS.name).load(user)
//    }
}