package com.ryohysk.graphqlkotlin.domain.service

import com.ryohysk.graphqlkotlin.domain.model.User
import com.ryohysk.graphqlkotlin.domain.repository.PointRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class PointServiceImp(val repository: PointRepository) : PointService {
    /**
     * ポイント取得処理
     */
    override fun findPointsBy(users: List<User>): List<Int> {
        println("実行は1回だけ。N+1は発生しない。")
        return users.parallelStream().map { repository.findUsersPointsMap()[it.id] ?: 0 }
                .collect(Collectors.toList<Int>())
    }
}