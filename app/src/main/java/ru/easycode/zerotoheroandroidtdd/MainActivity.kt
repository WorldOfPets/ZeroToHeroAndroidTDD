package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private var count:Count = Count.Base(2)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countTextView = findViewById<TextView>(R.id.countTextView)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        incrementButton.setOnClickListener {
            countTextView.text = count.increment(countTextView.text.toString())
        }
    }
}