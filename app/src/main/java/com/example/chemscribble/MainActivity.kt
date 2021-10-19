package com.example.chemscribble

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.scanlibrary.ScanConstants

import android.R.attr.data
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.lang.Exception
import androidx.core.app.ActivityCompat.startActivityForResult

import com.scanlibrary.ScanActivity





class MainActivity : AppCompatActivity() {
    var asList = false
    val mediaOptionsDialogKey = "media_options_dialog_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickIrisScan(v: View) {
        Log.d("use the view", v.id.toString())
        MediaOptionDialog().show(supportFragmentManager, mediaOptionsDialogKey)
    }

    val scanActivityResultHandler = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val uri: Uri = result.data?.extras?.getParcelable(ScanConstants.SCANNED_RESULT)!!
            try {
                findViewById<ImageView>(R.id.random).setImageURI(uri)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}