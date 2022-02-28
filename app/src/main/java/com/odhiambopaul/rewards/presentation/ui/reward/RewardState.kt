package com.odhiambopaul.rewards.presentation.ui.reward

import com.odhiambopaul.rewards.domain.model.Reward

data class RewardState(
    var isLoading: Boolean = false,
    var rewards: List<Reward?> = emptyList(),
    var error: String = ""
)
