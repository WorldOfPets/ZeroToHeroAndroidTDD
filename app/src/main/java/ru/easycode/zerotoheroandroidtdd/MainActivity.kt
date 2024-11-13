package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var loadButton: Button
    private var mainState:MainState = MainState.Uploaded
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById<TextView>(R.id.titleTextView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        loadButton = findViewById<Button>(R.id.actionButton)

        loadButton.setOnClickListener {
            lifecycleScope.launch {
                mainState = MainState.Loaded
                mainState.apply(titleTextView, progressBar, loadButton)
                delay(1000)

            }.invokeOnCompletion {
                mainState = MainState.Uploaded
                mainState.apply(titleTextView, progressBar, loadButton)
            }
        }
    }
}
interface MainState{
    fun apply(titleTextView: TextView, progressBar: ProgressBar, loadButton: Button)
    object Uploaded:MainState{
        override fun apply(titleTextView: TextView, progressBar: ProgressBar, loadButton: Button) {
            titleTextView.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
            loadButton.isEnabled = true
        }

    }
    object Loaded:MainState{
        override fun apply(titleTextView: TextView, progressBar: ProgressBar, loadButton: Button) {
            titleTextView.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            loadButton.isEnabled = false
        }

    }
}