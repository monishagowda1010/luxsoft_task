package com.dev.challenge.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev.challenge.challengeapp.api.ApiService
import com.dev.challenge.challengeapp.databinding.ActivityMainBinding
import com.dev.challenge.challengeapp.repository.MainRepository
import com.dev.challenge.challengeapp.ui.viewmodel.MainViewModel
import com.dev.challenge.challengeapp.ui.viewmodel.MyViewModelFactory


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = ApiService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        binding.recyclerview.adapter = adapter

        viewModel.userList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setUserList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "onCreate :$it")
            Toast.makeText(applicationContext, "API FAILED", Toast.LENGTH_LONG).show()
        })
        viewModel.getAllUsers()
    }
}