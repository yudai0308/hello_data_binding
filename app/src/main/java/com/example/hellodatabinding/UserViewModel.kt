package com.example.hellodatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData(User("John Doe"))
    private val _greeting = MutableLiveData("Hello, ${_user.value?.name}!")

    val user: LiveData<User> = _user
    val greeting: LiveData<String> = _greeting

    fun onClick() {
        _greeting.value = "Hello, ${user.value?.name}!"
    }

}

/**
 * User の name を双方向にバインドしたいので、getName と setName を実装する。
 */
class User(var name: String)
