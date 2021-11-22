package com.example.truthanddare

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.truthanddare.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spinButton.setOnClickListener{
            rotator()
        }
        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun rotator()
    {
        val random=Random()
        val initialAngle=viewModel.angle.value!!
        val finalAngle:Float=viewModel.angle.value!!+random.nextInt(360)+360
        val animator=ObjectAnimator.ofFloat(binding.bottleImage,View.ROTATION,initialAngle,finalAngle)
        animator.duration=2000
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                binding.spinButton.isEnabled = false
            }
            override fun onAnimationEnd(animation: Animator?) {
                binding.spinButton.isEnabled = true
            }
        })
        animator.start()
        viewModel.angle.value=finalAngle
    }
}