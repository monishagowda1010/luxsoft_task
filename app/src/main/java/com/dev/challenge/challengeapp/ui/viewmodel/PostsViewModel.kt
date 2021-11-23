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

) : ViewModel() {

}