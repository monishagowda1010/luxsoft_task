package com.dev.challenge.challengeapp.api.responses


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    var count: Int,
    @SerializedName("rate")
    var rate: Double
)