package com.pskda.androidlab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pskda.androidlab.databinding.FragmentFirstBinding
import com.pskda.androidlab.databinding.FragmentThrdBinding

class ThirdFragment: Fragment(R.layout.fragment_thrd) {
    private var binding: FragmentThrdBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThrdBinding.bind(view)

        binding?.run {
            titleTV3.text = "THIRD FRAGMENT!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}