package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.calculator.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val operations= listOf<View>(binding.button1,binding.button2,binding.button3,binding.button4)
        for(item in operations)
            item.setOnClickListener{op(it)}
    }
    private fun op(view:View)
    {
        val text1: String=binding.edit1.text.toString()
        val text2: String=binding.edit2.text.toString()
        if(text1!=""&&text2!="") {
            when (view) {
                binding.button1 -> setAnswer((text1.toInt() + text2.toInt()).toString())
                binding.button2 -> setAnswer((text1.toInt() - text2.toInt()).toString())
                binding.button3 -> setAnswer((text1.toInt() * text2.toInt()).toString())
                else -> setAnswer((text1.toInt() / text2.toInt()).toString())
            }
        }
        else
            setAnswer("!")
    }
    private fun setAnswer(answer:String)
    {
        binding.answerText.text=answer
    }
}