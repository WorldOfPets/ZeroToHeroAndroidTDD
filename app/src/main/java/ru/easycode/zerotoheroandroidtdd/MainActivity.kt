package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var uiState: UiState
    private val count = Count.Base(2, 4, 0)
    private lateinit var countTextView: TextView
    private lateinit var incButton: Button
    private lateinit var decButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTextView = findViewById(R.id.countTextView)
        incButton = findViewById(R.id.incrementButton)
        decButton = findViewById(R.id.decrementButton)
        uiState = count.initial(countTextView.text.toString())
        uiState.apply(countTextView, incButton, decButton)
        incButton.setOnClickListener {
            count.increment(countTextView.text.toString())
            uiState.apply(countTextView, incButton, decButton)
        }
        decButton.setOnClickListener {
            count.decrement(countTextView.text.toString())
            uiState.apply(countTextView, incButton, decButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("state", uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable("state", UiState::class.java) as UiState
        else
            savedInstanceState.getSerializable("state") as UiState
    }
}