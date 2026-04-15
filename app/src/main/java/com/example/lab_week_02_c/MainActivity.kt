package com.example.lab_week_02_c

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Button
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    companion object{
        private const val DEBUG = "DEBUG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(DEBUG, "onCreate")
        val buttonClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.button_standard -> startActivity(
                    Intent(this,
                        StandardActivity::class.java)
                )
                R.id.button_single_top -> startActivity(
                    Intent(this,
                        SingleTopActivity::class.java)
                )
            }
        }
        findViewById<Button>(R.id.button_standard).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button_single_top).setOnClickListener(buttonClickListener
        )
    }
}