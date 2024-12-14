package com.example.student_management

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.student_management.adapter.StudentListAdapter
import com.example.student_management.model.Model
import com.example.student_management.model.Student
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentsListActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)


        students = Model.shared.students

        val studentsList = findViewById<RecyclerView>(R.id.students_recycler_view)
        studentsList.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        studentsList.layoutManager = layoutManager

        val adapter = StudentListAdapter(students)
        adapter.listener = object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                Log.d("TAG", "On click Activity listener on position $position")
                val intent = Intent(this@StudentsListActivity, StudentDetailsActivity::class.java)
                intent.putExtra("studentIndex", position)
                startActivity(intent) // Start the new activity
                finish() // Finish the current activity
            }
        }
        studentsList.adapter = adapter

        val addStudentButton = findViewById<FloatingActionButton>(R.id.add_student_fab)

        addStudentButton.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity
        }

    }
}