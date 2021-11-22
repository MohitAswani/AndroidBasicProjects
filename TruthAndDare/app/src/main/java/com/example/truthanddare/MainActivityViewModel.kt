package com.example.truthanddare

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel() {

    var angle=MutableLiveData<Float>(90f)

}