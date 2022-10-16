package com.kodego.activity.one.studentassistanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityHomeBinding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name: String? = intent.getStringExtra("nameID")

        binding.tvHomePage.text = "Hello $name . . ."
    }
}