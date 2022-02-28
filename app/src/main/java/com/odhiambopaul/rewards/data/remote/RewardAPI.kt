package com.odhiambopaul.rewards.data.remote

import com.odhiambopaul.rewards.data.remote.dto.RewardListResponse
import retrofit2.http.GET

interface RewardAPI {
    @GET("/hiring.json")
    suspend fun getRewards(): RewardListResponse
}