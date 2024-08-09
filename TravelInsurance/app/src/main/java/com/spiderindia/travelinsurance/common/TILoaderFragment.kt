package com.spiderindia.travelinsurance.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.fragment.app.DialogFragment
import com.spiderindia.travelinsurance.R

class TILoaderFragment :  DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val loaderView = inflater.inflate(R.layout.fragment_t_i_loader,container,false)
        isCancelable = false
        loaderView.findViewById<ProgressBar>(R.id.commonProgressBar).visibility = View.VISIBLE
        return loaderView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE,0)
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val windows = it.window
            windows?.setBackgroundDrawableResource(android.R.color.transparent)

            val windowParams = windows?.attributes

            windowParams?.dimAmount = 1.06f
            windowParams?.flags != WindowManager.LayoutParams.FLAG_DIM_BEHIND
            windows?.attributes = windowParams
        }
    }
}