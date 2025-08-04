package com.example.medicore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.medicore.databinding.ActivityChoiceBinding
import nl.joery.animatedbottombar.AnimatedBottomBar
class choice : AppCompatActivity() {

    private lateinit var binding: ActivityChoiceBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        // ✅ Correct usage with NO import of OnTabSelectListener
        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newTab.id) {
                    R.id.homeFragment -> navController.navigate(R.id.homeFragment)
                    R.id.heartFragment -> navController.navigate(R.id.heartFragment)
                    R.id.eyeFragment -> navController.navigate(R.id.eyeFragment)
                    R.id.meditationFragment2 -> navController.navigate(R.id.meditationFragment2)
                    R.id.bloodFragment -> navController.navigate(R.id.bloodFragment)
                }
            }
        })



    }
}
