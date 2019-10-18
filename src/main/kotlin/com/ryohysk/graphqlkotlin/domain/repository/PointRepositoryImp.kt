package com.ryohysk.graphqlkotlin.domain.repository

import org.springframework.stereotype.Repository

@Repository
class PointRepositoryImp : PointRepository {
    override fun findUsersPointsMap() = mapOf(
            2L to 5000,
            1L to 1000,
            4L to 200,
            3L to 0
    )
}