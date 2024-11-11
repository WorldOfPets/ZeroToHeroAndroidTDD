package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

private var isShow = View.VISIBLE
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val hideButton = findViewById<Button>(R.id.hideButton)
        titleTextView.visibility = isShow
        hideButton.setOnClickListener {
            isShow = View.GONE
            titleTextView.visibility = isShow
        }
    }
}