package com.fitchstation.android.ui

import android.view.View
import com.fitchstation.android.base.BaseActivity
import com.fitchstation.android.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onBindViewResource(): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {

    }
}