package com.kodego.activity.one.studentassistanceapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.activity.one.studentassistanceapp.databinding.RowSubjectBinding

class StudentAdapter(val students:List<Students>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var onCardClick: ((Students)-> Unit)? = null
    inner class StudentViewHolder(val binding: RowSubjectBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowSubjectBinding.inflate(layoutInflater, parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {
            imgSubjectIcon.setImageResource(students[position].imageSubject)
            txtSubjectName.text = students[position].nameSubject
            txtSchedule.text = students[position].schedule
        }
        holder.itemView.setOnClickListener(){
            onCardClick?.invoke(students[position])
        }

    }

    override fun getItemCount(): Int {
        return students.size
    }
}