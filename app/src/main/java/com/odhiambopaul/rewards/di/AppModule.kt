package com.odhiambopaul.rewards.di

import com.odhiambopaul.rewards.common.Constants.BASE_URL
import com.odhiambopaul.rewards.data.remote.RewardAPI
import com.odhiambopaul.rewards.data.repository.RewardRepositoryImpl
import com.odhiambopaul.rewards.domain.repository.RewardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRewardAPI(): RewardAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RewardAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRewardRepository(api: RewardAPI): RewardRepository {
        return RewardRepositoryImpl(api = api)

    }
}