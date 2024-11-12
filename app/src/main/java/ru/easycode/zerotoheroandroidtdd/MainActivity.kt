package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var uiState:UiState = UiState.Base("0")
    private val count = Count.Base(step = 2, max = 4)
    private lateinit var titleTextView: TextView
    private lateinit var incButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById<TextView>(R.id.countTextView)
        incButton = findViewById<Button>(R.id.incrementButton)

        incButton.setOnClickListener {
            uiState = count.increment(titleTextView.text.toString())
            uiState.apply(titleTextView, incButton)
        }

    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("uiState", uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable("uiState", UiState::class.java) as UiState
        else
            savedInstanceState.getSerializable("uiState") as UiState
        uiState.apply(titleTextView, incButton)

    }


}