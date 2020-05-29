package com.example.hellodatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _name = MutableLiveData("John Doe")
    private val _greeting = MutableLiveData("Hello, ${_name.value}!")

    val name: LiveData<String> = _name
    val greeting: LiveData<String> = _greeting

    fun setName(name: String) {
        _name.value = name
    }

    fun onClick() {
        _greeting.value = "Hello, ${name.value}!"
    }

}
