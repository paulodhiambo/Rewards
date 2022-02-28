package com.odhiambopaul.rewards.domain.usecase.getrewards

import com.odhiambopaul.rewards.common.Resource
import com.odhiambopaul.rewards.data.remote.dto.toReward
import com.odhiambopaul.rewards.domain.model.Reward
import com.odhiambopaul.rewards.domain.repository.RewardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRewardsUseCase @Inject constructor(private val repository: RewardRepository) {
    operator fun invoke(): Flow<Resource<List<Reward?>>> = flow {
        try {
            emit(Resource.Loading())
            val rewards = repository.getRewards()
                .filter { it.name != null && it.name != "" }
            emit(
                Resource
                    .Success(rewards.map { it.toReward() }.sortedBy { it.listId }
                        .sortedBy { it.name })
            )
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "No Internet connection"))
        }
    }
}