package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.User

interface PointService {
    fun findPointsBy(users: List<User>): List<Int>
}