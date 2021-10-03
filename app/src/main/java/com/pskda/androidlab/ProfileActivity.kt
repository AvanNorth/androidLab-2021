package com.pskda.androidlab

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val editBTN: Button = findViewById(R.id.editBTN)
        val saveBTN: Button = findViewById(R.id.saveBTN)

        val emailET: EditText = findViewById(R.id.emailET)
        val emailTV: TextView = findViewById(R.id.emailTV)

        editBTN.setOnClickListener {
            editBTN.visibility = GONE
            saveBTN.visibility = VISIBLE
            emailTV.visibility = INVISIBLE
            emailET.setText(emailTV.text)
            emailET.visibility = VISIBLE
        }

        saveBTN.setOnClickListener {
            saveBTN.visibility = GONE
            editBTN.visibility = VISIBLE
            emailET.visibility = GONE
            emailTV.text = emailET.text
            emailTV.visibility = VISIBLE
        }
    }
}