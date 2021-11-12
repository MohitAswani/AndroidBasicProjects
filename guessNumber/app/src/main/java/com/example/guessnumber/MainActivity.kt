package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById<TextView>(R.id.textRandom)

        var handler=Handler()
        handler.post(object : Runnable{
            override fun run() {
                textView.text= Random().nextInt(10).toString()

                handler.postDelayed(this,1000)
            }
        })
    }
}