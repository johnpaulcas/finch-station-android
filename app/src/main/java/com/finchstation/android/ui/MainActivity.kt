package com.finchstation.android.ui

import android.view.View
import com.finchstation.android.base.BaseActivity
import com.finchstation.android.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onBindViewResource(): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {

    }
}