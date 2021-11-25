package com.pskda.androidlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pskda.androidlab.databinding.ActivityWakeupBinding

class WakeupActivity: AppCompatActivity() {
    private lateinit var binding: ActivityWakeupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWakeupBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }
}