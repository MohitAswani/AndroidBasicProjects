package com.example.reflexgame

import android.R
import android.R.id.button2
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.reflexgame.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            var random = Random()
            var num: Long = random.nextInt(10).toLong()

            var handler = Handler()
            handler.postDelayed(runnable, num * 1000)
        }
    }


    var runnable = Runnable {
        binding.constraintLayout.setBackgroundColor(Color.CYAN)

        val time: Long = System.currentTimeMillis()

        binding.stopButton.setOnClickListener(View.OnClickListener {
            val time1: Long = System.currentTimeMillis()
            Toast.makeText(this, "YOUR REACTION TIME WAS ${time1 - time} ms", Toast.LENGTH_SHORT)
                .show()

            binding.constraintLayout.setBackgroundColor(Color.GREEN)
        })
    }

}