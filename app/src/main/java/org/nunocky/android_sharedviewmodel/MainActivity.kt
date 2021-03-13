package org.nunocky.android_sharedviewmodel

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.nunocky.android_sharedviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content1, LeftFragment.createInstance(), "Left").commit()
            supportFragmentManager.beginTransaction()
                .replace(R.id.content2, RightFragment.createInstance(), "Right").commit()
        }

        viewModel.counter.observe(this) {
            Log.d("MainActivity", "count = ${viewModel.counter.value}")
        }

    }
}