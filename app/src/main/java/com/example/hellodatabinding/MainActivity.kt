package com.example.hellodatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
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

        binding.viewModel = userViewModel
        binding.lifecycleOwner = this
        binding.editText.addTextChangedListener { text ->
            userViewModel.setName(text.toString())
        }

//        // binding に lifecycleOwner を設定しない場合は一方向データバインディングとなり、
//        // 以下のようにデータが変更されたときの処理を書かないといけない。
//        userViewModel.greeting.observe(this, Observer { greeting ->
//            binding.textView.text = greeting
//        })

    }
}
