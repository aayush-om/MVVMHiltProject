package com.example.mvvmwithhilt

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmwithhilt.adapter.MarvelAdapter
import com.example.mvvmwithhilt.databinding.ActivityMainBinding
import com.example.mvvmwithhilt.viewmodel.MarvelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val marvelViewModel: MarvelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        marvelViewModel.getData()

        marvelViewModel.marvelResponse.observe(this, Observer {
            binding.marvelList.layoutManager = LinearLayoutManager(this)
            binding.marvelList.adapter = MarvelAdapter(it)
        })

    }

}