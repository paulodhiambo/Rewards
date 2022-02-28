package com.odhiambopaul.rewards.data.remote.dto

import com.odhiambopaul.rewards.domain.model.Reward

data class RewardItemResponse(
    val id: Int,
    val listId: Int,
    val name: String?
)

fun RewardItemResponse.toReward(): Reward {
    return Reward(id = id, listId = listId, name = name ?: "")
}