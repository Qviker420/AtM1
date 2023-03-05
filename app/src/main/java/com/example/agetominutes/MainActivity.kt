package com.example.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    var enteredDate:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickBtn:Button = findViewById(R.id.datePciker)
        enteredDate = findViewById(R.id.yourDate)
        val result: TextView = findViewById(R.id.ageToMins)

        datePickBtn.setOnClickListener {
            setDate()
        }
    }

    fun setDate()
    {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{view, year, month,dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month+1}/$year"
            enteredDate?.text = selectedDate.toString()
        },
            year,
            month,
            day
        ).show()
    }
}