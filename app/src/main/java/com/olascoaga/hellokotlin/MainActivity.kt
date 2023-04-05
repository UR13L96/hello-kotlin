package com.olascoaga.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    fun setupUI() {
        var message: String = findViewById<TextView>(R.id.tvHello).text.toString()

        Log.i("Message tvHello", message)
    }
}