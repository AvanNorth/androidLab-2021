package com.pskda.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lion: Lion = Lion()
        val raven: Raven = Raven()

        lion.voice()
        lion.beCute()

        raven.voice()
        raven.fly()
    }
}