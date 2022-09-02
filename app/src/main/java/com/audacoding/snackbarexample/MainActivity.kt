package com.audacoding.snackbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var tvNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootView = findViewById<CoordinatorLayout>(R.id.root)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add)
        tvNumber = findViewById(R.id.tv_number)

        fabAdd.setOnClickListener {
            addNumber(1)

            Snackbar.make(rootView, R.string.number_added, Snackbar.LENGTH_SHORT)
                .setAction(R.string.undo) {
                    addNumber(-1)
                }
                .show()
        }
    }

    private fun addNumber(number: Int) {
        var currentNumber = tvNumber.text.toString().toInt()
        currentNumber += number

        tvNumber.text = currentNumber.toString()

    }
}