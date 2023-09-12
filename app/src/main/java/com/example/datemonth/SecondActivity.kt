package com.example.datemonth

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigationrail.NavigationRailView

class SecondActivity : AppCompatActivity() {
    private lateinit var getdate: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val navRailFab: FloatingActionButton = findViewById(R.id.nav_rail_fab)
        navRailFab.setOnClickListener {
            Toast.makeText(this, "FAB Clicked!", Toast.LENGTH_SHORT).show()
        }

        val navigationRail: NavigationRailView = findViewById(R.id.navigationRail)
        navigationRail.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.inbox -> {
                    Toast.makeText(this, "Inbox", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.primary -> {
                    Toast.makeText(this, "Primary", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.social -> {
                    Toast.makeText(this, "Social", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.starred -> {
                    Toast.makeText(this, "Starred", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        getdate = findViewById(R.id.getdate)
        getdate.setOnClickListener {
            val dataPicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
            dataPicker.show(supportFragmentManager, dataPicker.toString())
        }
    }
}
