package com.example.newbooksapp.feature.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newbooksapp.R
import com.example.newbooksapp.databinding.ActivityMainBinding
import com.example.newbooksapp.databinding.FragmentBooksBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mABinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mABinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mABinding.root
        setContentView(view)
        setupNav()
    }


    private fun setupNav() {
        val navController = findNavController(R.id.my_nav_host)
        mABinding.bottomNavigatinView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.booksFragment -> showBottomNav()
                R.id.booksDetFragment -> hideBottomNav()
                R.id.authorsFragment -> showBottomNav()
                R.id.categoryFragment -> showBottomNav()
            }
        }

    }

    private fun showBottomNav() {
        mABinding.bottomNavigatinView.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        mABinding.bottomNavigatinView.visibility = View.GONE
    }
}