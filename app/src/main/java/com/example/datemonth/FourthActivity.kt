package com.example.datemonth

import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.FrameLayout


import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.google.android.material.sidesheet.SideSheetBehavior

class FourthActivity : AppCompatActivity() {
    private lateinit var more: MaterialButton
    private lateinit var leftArrowButton:MaterialButton

    @SuppressLint("WrongConstant", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        more = findViewById(R.id.more)
        leftArrowButton=findViewById(R.id.leftArrowButton)
        val sideSheet = findViewById<FrameLayout>(R.id.m3_side_sheet)
        val standardSideSheetBehavior = SideSheetBehavior.from(sideSheet)
        more.setOnClickListener {

            standardSideSheetBehavior.setState(STATE_EXPANDED)


        }
        val side = standardSideSheetBehavior.getState()
        if (side == STATE_HIDDEN) {
            more.isActivated
        }
        leftArrowButton.setOnClickListener {
standardSideSheetBehavior.hide()
        }

    }
}


