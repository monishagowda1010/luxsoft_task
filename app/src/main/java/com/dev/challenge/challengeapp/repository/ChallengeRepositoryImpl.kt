package com.dev.challenge.challengeapp.repository

import com.dev.challenge.challengeapp.api.ApiService
import com.dev.challenge.challengeapp.api.responses.GetPostsResponse
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ChallengeRepository {

}