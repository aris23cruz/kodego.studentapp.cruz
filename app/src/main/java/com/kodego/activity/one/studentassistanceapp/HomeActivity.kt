package com.kodego.activity.one.studentassistanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            Students(R.drawable.ic_baseline_offline_pin_24, "English","MWF 1:00PM-2:00PM"),
            Students(R.drawable.ic_baseline_ondemand_video_24,"Audio Visual","TTH 2:00PM-4:00PM"),
            Students(R.drawable.ic_baseline_paid_24, "Logic123", "MWF 3:00PM-4:00PM"),
            Students(R.drawable.ic_baseline_offline_pin_24, "English","MWF 1:00PM-2:00PM"),
            Students(R.drawable.ic_baseline_ondemand_video_24,"Audio Visual","TTH 2:00PM-4:00PM"),
            Students(R.drawable.ic_baseline_paid_24, "Logic123", "MWF 3:00PM-4:00PM"),
            Students(R.drawable.ic_baseline_offline_pin_24, "English","MWF 1:00PM-2:00PM"),
            Students(R.drawable.ic_baseline_ondemand_video_24,"Audio Visual","TTH 2:00PM-4:00PM"),
            Students(R.drawable.ic_baseline_paid_24, "Logic123", "MWF 3:00PM-4:00PM"),
        )
        val adapter = StudentAdapter(studentList)

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)



        var name: String? = intent.getStringExtra("nameID")
        binding.tvHomePage.text = "Hello $name . . ."
    }
}