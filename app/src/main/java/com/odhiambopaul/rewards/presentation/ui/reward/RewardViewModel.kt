package com.odhiambopaul.rewards.presentation.ui.reward

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambopaul.rewards.common.Resource
import com.odhiambopaul.rewards.domain.usecase.getrewards.GetRewardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RewardViewModel @Inject constructor(
    private val getRewardsUseCase: GetRewardsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(RewardState())
    val state: State<RewardState> = _state

    init {
        getRewards()
    }

    private fun getRewards() {
        getRewardsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RewardState(rewards = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = RewardState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = RewardState(error = result.message ?: "An error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}