package com.example.ics26011_mp5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar
import com.example.ics26011_mp5.databinding.ActivityMainBinding
import com.example.ics26011_mp5.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var button: Button
    lateinit var loadingProgress: ProgressBar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Retrieve user information from Intent
        val userName = intent.getStringExtra("USERNAME")
        val userEmail = intent.getStringExtra("EMAIL")
        button = binding.logoutBtn
        loadingProgress = binding.progressBar

        val username: TextView = findViewById(R.id.slogan_name)
        username.text = "Your name is: $userName"
        val email: TextView = findViewById(R.id.slogan_name2)
        email.text = "Your email is: $userEmail"

        button.setOnClickListener {
            button.visibility = View.INVISIBLE
            loadingProgress.visibility = View.VISIBLE
            Firebase.auth.signOut()

            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

    }
}