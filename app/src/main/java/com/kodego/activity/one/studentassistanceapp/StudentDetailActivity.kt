package com.kodego.activity.one.studentassistanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentDetailBinding

class StudentDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityStudentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nameSubject: String? = intent.getStringExtra("subjectName")
        var schedule: String? = intent.getStringExtra("schedule")
        var imageSubject: Int = intent.getIntExtra("subjectImage",0)

        binding.imgSubjectIcon2.setImageResource(imageSubject)
        binding.txtSubjectName2.text = nameSubject
        binding.txtSchedule2.text = schedule
    }
}