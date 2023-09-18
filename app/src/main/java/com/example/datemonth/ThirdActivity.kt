package com.example.datemonth


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_DRAGGING
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HALF_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import com.google.android.material.progressindicator.CircularProgressIndicator
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator


class ThirdActivity : AppCompatActivity() {

    private lateinit var circularIndicator: CircularProgressIndicator
    private lateinit var dotLayout: LinearLayout
    private lateinit var indicator: ScrollingPagerIndicator

    @SuppressLint("MissingInflatedId", "WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        indicator=findViewById(R.id.indicator)
        dotLayout = findViewById(R.id.dotLayout)
        circularIndicator = findViewById(R.id.circularIndicator)
        Handler().postDelayed({
            circularIndicator.visibility = View.INVISIBLE
        }, 3000)
        val standardBottomSheet = findViewById<FrameLayout>(R.id.standard_bottom_sheet)
        val standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        standardBottomSheetBehavior.setState(STATE_HALF_EXPANDED);
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val items = listOf(
            R.drawable.i1,
            R.drawable.i2,

            )

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val adapter = CarouselAdapter(items)
        recyclerView.adapter = adapter
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
//createDots(items.size)
//        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
//            override fun onScrolled(recyclerView: RecyclerView,dx:Int,dy:Int){
//                super.onScrolled(recyclerView,dx,dy)
//                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//                updateDots(firstVisibleItemPosition)
//
//            }
//        })
//    }
//    private fun createDots(count: Int) {
//        dotLayout.removeAllViews()
//        val dotSize = resources.getDimensionPixelSize(R.dimen.dot_size)
//        val dotMargin = resources.getDimensionPixelSize(R.dimen.dot_margin)
//
//        for (i in 0 until count) {
//            val dot = View(this)
//            val params = LinearLayout.LayoutParams(dotSize, dotSize)
//            params.setMargins(dotMargin, 0, dotMargin, 0)
//            dot.layoutParams = params
//            dot.setBackgroundResource(R.drawable.dot_unselected) // Use your dot drawable
//            dotLayout.addView(dot)
//        }
//    }
//
//    private fun updateDots(currentPosition: Int) {
//        for (i in 0 until dotLayout.childCount) {
//             val dot = dotLayout.getChildAt(i)
//            dot.setBackgroundResource(if (i == currentPosition) R.drawable.dot_selected else R.drawable.dot_unselected)
//        }
//    }
        indicator.attachToRecyclerView(recyclerView)
        indicator.dotColor = ContextCompat.getColor(this, R.color.dot_unselected_color)
        indicator.selectedDotColor = ContextCompat.getColor(this, R.color.dot_selected_color)
        indicator.setDotCount(2)

    }
}