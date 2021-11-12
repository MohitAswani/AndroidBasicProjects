package com.example.flashlight

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.hardware.camera2.CameraAccessException
import android.os.Build
import android.os.Build.VERSION_CODES.M
import android.view.View
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    private lateinit var torchButton:ToggleButton
    private lateinit var imageView: ImageView
    private lateinit var cameraManager:CameraManager
    private var cameraID:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        torchButton=findViewById(R.id.toggleButton)
        imageView=findViewById(R.id.imageView)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager;

        try {
            // O means back camera unit,
            // 1 means front camera unit
            cameraID = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        torchButton.setOnClickListener{toggleFlashLight(it)}
    }

    fun toggleFlashLight(view: View)
    {
        if (torchButton.isChecked)
        {
            imageView.setImageResource(R.drawable.ic_baseline_flash_on_24)
            try {
                cameraManager.setTorchMode(cameraID,true)
            }
            catch(e: CameraAccessException)
            {
                e.printStackTrace()
            }
        }
        else
        {
            imageView.setImageResource(R.drawable.ic_baseline_flash_off_24)
            try {
                cameraManager.setTorchMode(cameraID,false)
            }
            catch(e: CameraAccessException)
            {
                e.printStackTrace()
            }
        }

    }

    override fun finish() {
        super.finish()
        try {
            cameraManager.setTorchMode(cameraID,false)
        }
        catch(e: CameraAccessException)
        {
            e.printStackTrace()
        }
    }

}