package com.pskda.androidlab.fragments.secondFrgmt

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.pskda.androidlab.databinding.DialogBinding

class Dialog : DialogFragment() {

    private lateinit var binding: DialogBinding

    var positiveCallback: ((List<String>) -> Unit)? = null
    //var positiveCallback: ((String) -> Unit)? = null


    override fun onCreateDialog(
        savedInstanceState: Bundle?
    ): Dialog = AlertDialog.Builder(requireContext())
        .setView(DialogBinding.inflate(layoutInflater).let {
            binding = it
            it.root
        })
        .setPositiveButton("OK") { _, _ ->
            positiveCallback?.invoke(  arrayListOf("${binding.etName.text}",
                "${binding.etDesc.text}",
                "${binding.etPos.text}"))
        }
        .setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        .create()

    companion object {
        fun show(
            fragmentManager: FragmentManager,
            positive: (List<String?>) -> Unit
            //positive: (String) -> Unit
        ) {
            Dialog().apply {
                positiveCallback = positive
                show(fragmentManager, Dialog::class.java.name)
            }
        }
    }
}