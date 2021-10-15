package com.pskda.androidlab

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pskda.androidlab.databinding.ActivityFirstBinding
import com.pskda.androidlab.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val text:String? = intent.getStringExtra(Intent.EXTRA_TEXT)
        binding.textView.text = text
    }
}