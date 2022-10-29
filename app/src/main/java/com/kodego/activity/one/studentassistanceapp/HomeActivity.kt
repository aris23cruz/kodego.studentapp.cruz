package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityHomeBinding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var studentList = mutableListOf<Students>(
            Students(R.drawable.english, "English","MWF 1:00PM-2:00PM"),
            Students(R.drawable.biology,"General Biology","TTH 2:00PM-4:00PM"),
            Students(R.drawable.calculus, "Pre-Calculus", "MWF 3:00PM-4:00PM"),
            Students(R.drawable.chemistry, "General Chemistry","MWF 1:00PM-2:00PM"),
            Students(R.drawable.commandresearch,"Comms & Research","TTH 2:00PM-4:00PM"),
            Students(R.drawable.math, "General Math", "MWF 3:00PM-4:00PM"),
            Students(R.drawable.personaldev, "Personal Development","MWF 1:00PM-2:00PM"),
            Students(R.drawable.physicaleducation,"Physical Education","TTH 2:00PM-4:00PM"),
            Students(R.drawable.physics, "General Physics", "MWF 3:00PM-4:00PM"),
        )
        val adapter = StudentAdapter(studentList)
        adapter.onCardClick = {
            val intent = Intent(this,StudentDetailActivity::class.java)
            intent.putExtra("subjectName",it.nameSubject)
            intent.putExtra("schedule",it.schedule)
            intent.putExtra("subjectImage",it.imageSubject)
            startActivity(intent)
        }

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)



        var name: String? = intent.getStringExtra("nameID")
        binding.tvHomePage.text = "Hello $name . . ."
    }
}