package com.example.chemscribble

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.scanlibrary.ScanActivity
import com.scanlibrary.ScanConstants

class MediaOptionDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
            .setPositiveButton("Open Camera") { _, _ ->
                val intent = Intent(requireContext(), ScanActivity::class.java)
                intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, ScanConstants.OPEN_CAMERA)
                (requireActivity() as MainActivity).scanActivityResultHandler.launch(intent)
            }.setNegativeButton("Open Files") {_, _ ->
                val intent = Intent(requireContext(), ScanActivity::class.java)
                intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, ScanConstants.OPEN_MEDIA)
                (requireActivity() as MainActivity).scanActivityResultHandler.launch(intent)
            }
        return builder.create()
    }
}