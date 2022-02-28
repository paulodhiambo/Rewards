package com.odhiambopaul.rewards.domain.repository

import com.odhiambopaul.rewards.data.remote.dto.RewardListResponse

interface RewardRepository {
    suspend fun getRewards(): RewardListResponse
}