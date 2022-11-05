package com.kodego.activity.one.studentassistanceapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.activity.one.studentassistanceapp.databinding.RowSubjectBinding

class StudentAdapter(val students:MutableList<Students>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var onCardClick: ((Students)-> Unit)? = null
    var onUpdateButtonClick : ((Students,Int)-> Unit)? = null
    var onDeleteButtonClick : ((Students,Int)-> Unit)? = null

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
            txtTeachersName.text = students[position].teacherName
            imgButtonUpdate.setOnClickListener (){
                onUpdateButtonClick?.invoke(students[position],position)
            }
            imgButtonDelete.setOnClickListener(){
                onDeleteButtonClick?.invoke(students[position],position)
            }
        }
        holder.itemView.setOnClickListener(){
            onCardClick?.invoke(students[position])
        }

    }

    override fun getItemCount(): Int {
        return students.size
    }
}