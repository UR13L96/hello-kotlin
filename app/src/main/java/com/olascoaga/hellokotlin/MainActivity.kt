package com.olascoaga.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)
        setupListeners()
    }

    private fun setupListeners() {
        findViewById<Button>(R.id.btnPlay).setOnClickListener {
            speak()
        }
    }

    private fun speak() {
        var message: String = findViewById<TextView>(R.id.tvHello).text.toString()

        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.tvHello).text = "Hello Kotlin!"
            tts!!.setLanguage(Locale.US)
        } else {
            findViewById<TextView>(R.id.tvHello).text = "Not available :c"
        }
    }
}