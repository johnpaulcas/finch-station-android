package com.fitchstation.android.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(onBindViewResource())
        init()
    }

    abstract fun onBindViewResource(): View?

    abstract fun init()

}