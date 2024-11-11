package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

private var isDeleted = false
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val container = findViewById<LinearLayout>(R.id.rootLayout)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val removeButton = findViewById<TextView>(R.id.removeButton)

        if (isDeleted){
            container.removeView(titleTextView)
        }
        removeButton.setOnClickListener {
            isDeleted = true
            container.removeView(titleTextView)
        }
    }
}