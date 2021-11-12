package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {
    private var seconds:Int=0
    private var running:Boolean=false
    private var wasRunning:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState!=null)
        {
            seconds=savedInstanceState.getInt("seconds")
            running=savedInstanceState.getBoolean("running")
            wasRunning=savedInstanceState.getBoolean("wasRunning")
        }

        var start:TextView=findViewById<Button>(R.id.startbutton)
        var stop:TextView=findViewById<Button>(R.id.stopbutton)
        var reset:TextView=findViewById<Button>(R.id.resetbutton)

        start.setOnClickListener{onClickStart(it)}
        stop.setOnClickListener{onClickStop(it)}
        reset.setOnClickListener{onClickReset(it)}

        runTimer()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seconds",seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning",wasRunning)
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        wasRunning=running
        running=false
    }

    override fun onResume() {
        super.onResume()
        if(wasRunning)
            running=true
    }

    fun onClickStart(view: View)
    {
        running=true
    }

    fun onClickStop(view: View)
    {
        running=false
    }

    fun onClickReset(view: View)
    {
        running=false
        seconds=0
    }

    fun runTimer(){
        val textView:TextView=findViewById(R.id.textview1)
        val handler:Handler= Handler()

        handler.post( object : Runnable{
            override fun run() {
                var hour:Int=seconds/3600
                var minutes:Int=(seconds%3600)/60
                var secs=seconds%60

                var time:String=String.format(Locale.getDefault(),"%02d:%02d:%02d",hour,minutes,secs)

                textView.setText(time)

                if(running)
                    seconds++

                handler.postDelayed(this,1000)
            }
        })

    }
}