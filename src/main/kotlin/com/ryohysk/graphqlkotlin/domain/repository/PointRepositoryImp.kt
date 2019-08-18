package com.ryohysk.graphqlkotlin.domain.repository

import org.springframework.stereotype.Repository

@Repository
class PointRepositoryImp : PointRepository {
    override fun findUsersPointsMap() = mapOf(
            2 to 5000,
            1 to 1000,
            4 to 200,
            3 to 0
    )
}