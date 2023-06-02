package com.innaval.searchingithub.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innaval.searchingithub.R
import com.innaval.searchingithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setTheme(R.style.Theme_Main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}