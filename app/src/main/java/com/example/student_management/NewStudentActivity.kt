package com.example.student_management

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.student_management.model.Model
import com.example.student_management.model.Student

class NewStudentActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students

        val saveButton: Button = findViewById(R.id.add_student_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_cancel_button)
        val nameTextField: EditText = findViewById(R.id.add_student_name_text_field)
        val idTextField: EditText = findViewById(R.id.add_student_id_text_field)
        val phoneTextField: EditText = findViewById(R.id.add_student_phone_text_field)
        val addressTextField: EditText = findViewById(R.id.add_student_address_text_field)
        val checkedButton: CheckBox = findViewById(R.id.add_student_checked)

        saveButton.setOnClickListener {
            val name = nameTextField.text.toString()
            val id = idTextField.text.toString()
            val phone = phoneTextField.text.toString()
            val address = addressTextField.text.toString()
            val isChecked = checkedButton.isChecked

            val student = Student(id, name, phone, address, "@drawable/avatar", isChecked)

            students?.add(student)

            val intent = Intent(this, StudentsListActivity::class.java)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity

        }

        cancelButton.setOnClickListener {
            val intent = Intent(this, StudentsListActivity::class.java)
            startActivity(intent) // Start the new activity
            finish() // Finish the current activity
        }
    }
}