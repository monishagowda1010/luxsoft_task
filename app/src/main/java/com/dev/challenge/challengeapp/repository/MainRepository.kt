package com.dev.challenge.challengeapp.repository


import com.dev.challenge.challengeapp.api.ApiService
import retrofit2.Response

class MainRepository constructor(private val retrofitService: ApiService) {

    fun getAllUsers() = retrofitService.getAllUsers()
}