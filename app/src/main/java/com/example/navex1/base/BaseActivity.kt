package com.example.navex1.base

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun updateTitleBar(title: String?) {
        supportActionBar?.title = title
    }
}