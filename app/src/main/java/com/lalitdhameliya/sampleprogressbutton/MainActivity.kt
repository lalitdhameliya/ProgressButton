package com.lalitdhameliya.sampleprogressbutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testing_button.setOnClickListener { testing_button.showProgress(true) }
        test.setOnClickListener { test.showProgress(true) }
    }
}
