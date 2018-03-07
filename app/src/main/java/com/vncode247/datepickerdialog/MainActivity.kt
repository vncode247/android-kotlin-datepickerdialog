package com.vncode247.datepickerdialog

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    // store selected date
    private var selectedYear = 0
    private var selectedMonth = 0
    private var selectedDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get view
        val tvDate = findViewById<TextView>(R.id.tvDate)
        tvDate.setOnClickListener {
            // get current date
            val currentDate = Calendar.getInstance()
            var year = currentDate.get(Calendar.YEAR)
            var month = currentDate.get(Calendar.MONTH)
            var day = currentDate.get(Calendar.DAY_OF_MONTH)

            if (tvDate.text.isNotEmpty()) {
                year = this.selectedYear
                month = this.selectedMonth
                day = this.selectedDay
            }

            // create listener
            val listener = DatePickerDialog.OnDateSetListener { datePicker, selectedYear, selectedMonth, selectedDay ->
                this.selectedYear = selectedYear
                this.selectedMonth = selectedMonth
                this.selectedDay = selectedDay

                tvDate.text = "${selectedMonth + 1}/$selectedDay/$selectedYear"
            }

            // create picker
            val datePicker = DatePickerDialog(this, listener, year, month, day)
            datePicker.show()
        }
    }
}
