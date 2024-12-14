package com.example.student_management

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.student_management.model.Model
import com.example.student_management.model.Student

class NewStudentActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    // Handle the back button press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, StudentsListActivity::class.java)
                startActivity(intent) // Start the new activity
                finish() // Finish the current activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}