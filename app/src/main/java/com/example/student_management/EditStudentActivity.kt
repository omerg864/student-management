package com.example.student_management

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.student_management.model.Model
import com.example.student_management.model.Student

class EditStudentActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        students = Model.shared.students


        val studentIndex = intent.getIntExtra("studentIndex", 0)

        val student = students?.get(studentIndex)

        val studentName = findViewById<EditText>(R.id.edit_student_name_text_field)
        val studentId = findViewById<EditText>(R.id.edit_student_id_text_field)
        val studentPhone = findViewById<EditText>(R.id.edit_student_phone_text_field)
        val studentAddress = findViewById<EditText>(R.id.edit_student_address_text_field)
        val checkedButton = findViewById<CheckBox>(R.id.edit_student_checked)

        checkedButton.isChecked = student?.isChecked ?: false

        studentName.setText(student?.name)
        studentId.setText(student?.id)
        studentPhone.setText(student?.phone)
        studentAddress.setText(student?.address)

        val saveButton = findViewById<Button>(R.id.edit_student_save_button)

        saveButton.setOnClickListener {
            student?.name = studentName.text.toString()
            student?.id = studentId.text.toString()
            student?.phone = studentPhone.text.toString()
            student?.address = studentAddress.text.toString()
            student?.isChecked = checkedButton.isChecked

            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("studentIndex", studentIndex)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity
        }

        val cancelButton = findViewById<Button>(R.id.edit_student_cancel_button)

        cancelButton.setOnClickListener {
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("studentIndex", studentIndex)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity
        }

        val deleteButton = findViewById<Button>(R.id.edit_student_delete_button)

        deleteButton.setOnClickListener {
            students?.removeAt(studentIndex)
            val intent = Intent(this, StudentsListActivity::class.java)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity
        }

    }
}