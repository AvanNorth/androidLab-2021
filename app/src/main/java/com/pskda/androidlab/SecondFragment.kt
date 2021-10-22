package com.pskda.androidlab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pskda.androidlab.databinding.FragmentFirstBinding
import com.pskda.androidlab.databinding.FragmentScndBinding

class SecondFragment: Fragment(R.layout.fragment_scnd){
    private var binding: FragmentScndBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScndBinding.bind(view)

        binding?.run {
            titleTV2.text = "SECOND FRAGMENT!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}