package com.ryohysk.graphqlkotlin.domain.context

import com.ryohysk.graphqlkotlin.domain.enumeration.DataLoaderKey
import com.ryohysk.graphqlkotlin.domain.model.Product
import com.ryohysk.graphqlkotlin.domain.model.User
import com.ryohysk.graphqlkotlin.domain.service.PointService
import com.ryohysk.graphqlkotlin.domain.service.ProductService
import graphql.servlet.context.*
import org.dataloader.DataLoader
import org.dataloader.DataLoaderRegistry
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.websocket.Session
import javax.websocket.server.HandshakeRequest

@Component
class UserContextBuilder(private val pointService: PointService,
                         private val productService: ProductService
) : GraphQLContextBuilder {
    override fun build(request: HttpServletRequest, response: HttpServletResponse): GraphQLContext =
            DefaultGraphQLServletContext.createServletContext(buildDataLoaderRegistry(), null)
                    .with(request).with(response).build()

    override fun build(): GraphQLContext = DefaultGraphQLContext(buildDataLoaderRegistry(), null)

    override fun build(session: Session, request: HandshakeRequest): GraphQLContext =
            DefaultGraphQLWebSocketContext.createWebSocketContext(buildDataLoaderRegistry(), null)
                    .with(session).with(request).build()

    /**
     * データローダーの登録を行う
     */
    private fun buildDataLoaderRegistry() = DataLoaderRegistry().apply {
        this.register(DataLoaderKey.USERS_POINTS.name, DataLoader<User, Int> {
            CompletableFuture.supplyAsync {
                pointService.findPointsBy(it)
            }
        })
        this.register(DataLoaderKey.FAVORITE_PRODUCTS.name, DataLoader<User, List<Product>> {
            CompletableFuture.supplyAsync {
                productService.findFavoriteProducts(it)
            }
        })
    }
}