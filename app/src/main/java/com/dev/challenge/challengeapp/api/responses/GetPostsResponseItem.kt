package com.dev.challenge.challengeapp.api.responses


import com.google.gson.annotations.SerializedName

data class GetPostsResponseItem(
    @SerializedName("body")
    var body: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int
)