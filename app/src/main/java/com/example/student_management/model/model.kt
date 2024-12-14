package com.example.student_management.model

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Ben Shapiro $i",
                id = i.toString(),
                address = "California",
                phone = "123456789",
                avatarUrl = "",
                isChecked = false
            )
            students.add(student)
        }
    }
}