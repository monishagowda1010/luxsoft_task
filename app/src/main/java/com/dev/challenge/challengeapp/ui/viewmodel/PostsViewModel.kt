package com.dev.challenge.challengeapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.challenge.challengeapp.api.responses.GetPostsResponse
import com.dev.challenge.challengeapp.repository.ChallengeRepository
import com.dev.challenge.challengeapp.ui.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: ChallengeRepository
) : ViewModel() {

    private var _posts: MutableLiveData<Resource<GetPostsResponse>> = MutableLiveData()
    val posts: LiveData<Resource<GetPostsResponse>> get() = _posts

    init {
        viewModelScope.launch {
            try {
                _posts.value = Resource.Loading(null)
                val response = repository.getAllPosts()
                Log.d("log","response")
                _posts.value = Resource.Success(response)
            } catch (e: Exception) {
                e.printStackTrace()
                _posts.value = Resource.Error(e.toString(), null)
            }
        }
    }

}