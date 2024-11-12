package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState :Serializable {
    fun apply(textView: TextView, incBtn:Button, decBtn:Button)
    data class Base(private val text:String):UiState{
        override fun apply(textView: TextView, incBtn: Button, decBtn: Button) {
            textView.text = text
            incBtn.isEnabled = true
            decBtn.isEnabled = true
        }

    }
    data class Max(private val text: String):UiState{
        override fun apply(textView: TextView, incBtn: Button, decBtn: Button) {
            textView.text = text
            incBtn.isEnabled = false
            decBtn.isEnabled = true
        }

    }
    data class Min(private val text: String):UiState{
        override fun apply(textView: TextView, incBtn: Button, decBtn: Button) {
            textView.text = text
            incBtn.isEnabled = true
            decBtn.isEnabled = false
        }

    }
}