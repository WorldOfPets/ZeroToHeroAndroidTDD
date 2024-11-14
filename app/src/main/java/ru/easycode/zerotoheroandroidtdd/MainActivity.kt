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
    private var viewModel: MainViewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.titleTextView)
        progressBar = findViewById(R.id.progressBar)
        loadButton = findViewById(R.id.actionButton)

        loadButton.setOnClickListener {
            viewModel.load()
            viewModel.uiState.observe(this){
                if(it != null){
                    if (it.equals(UiState.ShowProgress)){
                        progressBar.visibility = View.VISIBLE
                        loadButton.isEnabled = false
                    }else if (it.equals(UiState.ShowData)){
                        progressBar.visibility = View.GONE
                        loadButton.isEnabled = true
                        titleTextView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}