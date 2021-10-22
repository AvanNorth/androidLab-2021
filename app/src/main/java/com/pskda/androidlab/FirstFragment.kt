package com.pskda.androidlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pskda.androidlab.databinding.FragmentFirstBinding

class FirstFragment: Fragment(R.layout.fragment_first) {
    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding?.run {
            titleTV1.text = "FIRST FRAGMENT!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}