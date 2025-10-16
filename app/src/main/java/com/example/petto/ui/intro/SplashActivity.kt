package com.example.petto.ui.intro

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.petto.R
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        auth = FirebaseAuth.getInstance()
        prefs = getSharedPreferences("PettoPrefs", MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({
            if (auth.currentUser != null) {
                startActivity(Intent(this, com.example.petto.ui.HomeActivity::class.java))
            } else {
                startActivity(Intent(this, com.example.petto.ui.intro.IntroActivity::class.java))
            }
            finish()
        }, 3000)
    }
}
