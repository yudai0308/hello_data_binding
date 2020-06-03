package com.example.hellodatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.hellodatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        /**
         * binding に lifecycleOwner を設定しないと双方向にデータバインディングできない。
         */
        binding.apply {
            viewModel = userViewModel
            lifecycleOwner = this@MainActivity
        }

        /**
         * 双方向データバインディングでは以下のような処理が必要ない。
         */

//        binding.editText.addTextChangedListener { text ->
//            userViewModel.setName(text.toString())
//        }

//        userViewModel.greeting.observe(this, Observer { greeting ->
//            binding.textView.text = greeting
//        })

    }
}
