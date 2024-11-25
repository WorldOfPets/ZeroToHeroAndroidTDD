package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView:TextView
    private lateinit var progressBar:ProgressBar
    private lateinit var loadButton:Button
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (applicationContext as MyApp).viewModel
        titleTextView = findViewById(R.id.titleTextView)
        progressBar = findViewById(R.id.progressBar)
        loadButton = findViewById(R.id.actionButton)

        loadButton.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData().observe(this){uiState ->
            uiState.apply(loadButton, progressBar, titleTextView)
        }
    }
}