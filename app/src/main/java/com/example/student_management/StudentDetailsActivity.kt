package com.example.student_management

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.student_management.model.Model
import com.example.student_management.model.Student

class StudentDetailsActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)


        students = Model.shared.students

        val studentIndex = intent.getIntExtra("studentIndex", 0)

        val student = students?.get(studentIndex)

        val studentName = findViewById<TextView>(R.id.student_details_name)
        val studentId = findViewById<TextView>(R.id.student_details_id)
        val studentPhone = findViewById<TextView>(R.id.student_details_phone)
        val studentAddress = findViewById<TextView>(R.id.student_details_address)
        val checkedButton = findViewById<CheckBox>(R.id.student_details_checked)

        checkedButton.isChecked = student?.isChecked ?: false

        studentName.text = student?.name
        studentId.text = student?.id
        studentPhone.text = student?.phone
        studentAddress.text = student?.address

        val editButton = findViewById<TextView>(R.id.student_details_edit_button)
        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentIndex", studentIndex)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity
        }

        checkedButton.setOnClickListener {
            student?.isChecked = checkedButton.isChecked
        }

    }
}