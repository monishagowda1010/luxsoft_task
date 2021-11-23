package com.dev.challenge.challengeapp.di

import com.dev.challenge.challengeapp.repository.ChallengeRepository
import com.dev.challenge.challengeapp.repository.ChallengeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsChallengeRepository(challengeRepositoryImpl: ChallengeRepositoryImpl): ChallengeRepository

}