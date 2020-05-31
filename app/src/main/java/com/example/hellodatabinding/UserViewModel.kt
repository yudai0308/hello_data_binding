package com.example.hellodatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    /**
     * ここでもし User モデルではなく、単に String 型の LiveData を使ってしまうと
     * 双方向データバインディングが実現できなくなるので注意。
     * User モデルを実装し、getName と setName を実装する必要がある。
     */
    private val _user = MutableLiveData(User("John Doe"))
    private val _greeting = MutableLiveData("Hello, ${_user.value?.name}!")

    val user: LiveData<User> = _user
    val greeting: LiveData<String> = _greeting

    fun onClick() {
        _greeting.value = "Hello, ${user.value?.name}!"
    }

}

class User(var name: String)
