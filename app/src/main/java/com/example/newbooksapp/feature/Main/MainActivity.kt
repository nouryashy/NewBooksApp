package com.example.newbooksapp.feature.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newbooksapp.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}