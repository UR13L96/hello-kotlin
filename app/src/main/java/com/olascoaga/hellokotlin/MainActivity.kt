package com.olascoaga.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
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
        var message: String = findViewById<TextView>(R.id.etMessage).text.toString()

        if (message.isEmpty()) {
            findViewById<TextView>(R.id.tvHello).text = getString(R.string.tts_message_empty)
            message = "¿Me quieres ver la cara de estúpida?"
        }

        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.tvHello).text = getString(R.string.tts_ready)
            tts!!.language = Locale("es_MX")
        } else {
            findViewById<TextView>(R.id.tvHello).text = getString(R.string.tts_not_available)
        }
    }

    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}