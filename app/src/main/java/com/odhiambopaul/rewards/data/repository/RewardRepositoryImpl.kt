package com.odhiambopaul.rewards.data.repository

import com.odhiambopaul.rewards.data.remote.RewardAPI
import com.odhiambopaul.rewards.data.remote.dto.RewardListResponse
import com.odhiambopaul.rewards.domain.repository.RewardRepository
import javax.inject.Inject

class RewardRepositoryImpl @Inject constructor(private val api: RewardAPI) : RewardRepository {
    override suspend fun getRewards(): RewardListResponse {
        return api.getRewards()
    }

}