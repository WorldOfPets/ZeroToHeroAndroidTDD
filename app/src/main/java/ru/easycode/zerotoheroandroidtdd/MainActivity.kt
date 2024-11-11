package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private var text = "Hello World!"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val changeButton = findViewById<Button>(R.id.changeButton)
        titleTextView.text = text
        changeButton.setOnClickListener {
            text = "I am an Android Developer!"
            titleTextView.text = text
        }
    }
}