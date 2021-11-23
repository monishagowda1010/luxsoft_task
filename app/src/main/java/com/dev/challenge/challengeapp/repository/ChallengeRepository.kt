package com.dev.challenge.challengeapp.repository

import com.dev.challenge.challengeapp.api.responses.GetPostsResponse

interface ChallengeRepository {
    suspend fun getAllPosts(): GetPostsResponse
}