package com.ryohysk.graphqlkotlin.domain.repository

interface PointRepository {
    fun findUsersPointsMap(): Map<Int, Int>
}