package com.kodego.activity.one.studentassistanceapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityHomeBinding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityMainBinding
import com.kodego.activity.one.studentassistanceapp.databinding.AddDialogBinding
import com.kodego.activity.one.studentassistanceapp.databinding.TeacherNameDialogBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var adapter : StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var studentList : MutableList<Students> = mutableListOf<Students>(
            Students(R.drawable.english, "English","MWF 1:00PM-2:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.biology,"General Biology","TTH 2:00PM-4:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.calculus, "Pre-Calculus", "MWF 3:00PM-4:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.chemistry, "General Chemistry","MWF 1:00PM-2:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.commandresearch,"Comms & Research","TTH 2:00PM-4:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.math, "General Math", "MWF 3:00PM-4:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.personaldev, "Personal Development","MWF 1:00PM-2:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.physicaleducation,"Physical Education","TTH 2:00PM-4:00PM","Mr./Mrs/Ms."),
            Students(R.drawable.physics, "General Physics", "MWF 3:00PM-4:00PM","Mr./Mrs/Ms."),
        )
        adapter = StudentAdapter(studentList)
        adapter.onCardClick = {
            val intent = Intent(this,StudentDetailActivity::class.java)
            intent.putExtra("subjectName",it.nameSubject)
            intent.putExtra("schedule",it.schedule)
            intent.putExtra("subjectImage",it.imageSubject)
            intent.putExtra("teacherName",it.teacherName)
            startActivity(intent)
        }
        adapter.onUpdateButtonClick = { item:Students, position: Int ->
            showUpdateDialog(item, position)
        }
        adapter.onDeleteButtonClick = { item:Students, position : Int ->
            adapter.students.removeAt(position)
            adapter.notifyDataSetChanged()
        }
        binding.floatingActionButton.setOnClickListener(){
            showAddDialog()
        }

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)

        var name: String? = intent.getStringExtra("nameID")
        binding.tvHomePage.text = "Hello $name . . ."
    }

    private fun showAddDialog() {
        val dialog = Dialog(this)
        val binding : AddDialogBinding = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        val images = arrayListOf<String>("biology","calculus",
            "chemistry","commandresearch","english","math",
            "personaldev","physicaleducation","physics"
        )
        val spinnerAdapter = ArrayAdapter(applicationContext,R.layout.text_view,images)
        binding.spnImage.adapter = spinnerAdapter

        binding.btnAdd.setOnClickListener() {
            var image: Int = resources.getIdentifier(binding.spnImage.selectedItem.toString(),"drawable",packageName)
            var itemSubject : String = binding.etDialogSubject.text.toString()
            var itemSchedule : String = binding.etSchedule.text.toString()
            var teacherName : String = binding.etTeachersName.text.toString()

            adapter.students.add(Students(image, itemSubject, itemSchedule, teacherName))
            adapter.notifyItemInserted(adapter.itemCount + 1)
            dialog.dismiss()
        }
    }

    private fun showUpdateDialog(item: Students, position: Int) {
        val dialog = Dialog(this)
        val binding : TeacherNameDialogBinding = TeacherNameDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnUpdateDialog.setOnClickListener(){
            var newSchedule : String = binding.etEditSchedule.text.toString()
            adapter.students[position].schedule = newSchedule
            var newTeacherName : String = binding.etTeachersNameDialog.text.toString()
            adapter.students[position].teacherName = newTeacherName
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
    }
}