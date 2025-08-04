package com.example.medicore

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.medicore.databinding.ActivitySplashScreenBinding

class splashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.lottieAnimationView.setAnimation("splash_anim1.json")
        binding.lottieAnimationView.playAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,loginPage::class.java))
            finish()
        },3000)


    }
}