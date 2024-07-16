package com.spiderindia.travelinsurance.slider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.spiderindia.travelinsurance.R

class IntroViewFragment : Fragment()
{

    private var introInfo : IntroInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        arguments?.let {
            introInfo = it.getParcelable("INTRO_INFO")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro_view, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        introInfo?.image?.let {
            view?.findViewById<ImageView>(R.id.ivIntro)?.setImageResource(it)
        }
        this.view?.findViewById<TextView>(R.id.tvTitle)?.text = introInfo?.title
        this.view?.findViewById<TextView>(R.id.tvDataInterval)?.text = introInfo?.description
    }

    companion object{
        @JvmStatic
        fun newInstance(introInfo: IntroInfo) =
            IntroViewFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("INTRO_INFO", introInfo)
            }
        }
    }



}