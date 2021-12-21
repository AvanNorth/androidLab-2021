package com.pskda.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pskda.androidlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            switchFragment(FirstFragment(),false)
        }

        binding.button1.setOnClickListener {
           switchFragment(FirstFragment(),true)
        }

        binding.button2.setOnClickListener {
            switchFragment(SecondFragment(),true)
        }

        binding.button3.setOnClickListener {
           switchFragment(ThirdFragment(),true)
        }
    }

    private fun switchFragment(fragment: Fragment, backStackAllowed: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.fragment_close_enter, R.anim.fragment_close_exit)
        transaction.replace(R.id.fragmentContainerView, fragment)
        if (backStackAllowed)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}