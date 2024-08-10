package com.spiderindia.travelinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayoutMediator
import com.spiderindia.travelinsurance.slider.IntroInfo
import com.spiderindia.travelinsurance.slider.ScreenSliderPageAdapter

val listOfItem = mutableListOf<IntroInfo>()

class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    override fun onResume() {
        super.onResume()
        val supportActivity = activity as? AppCompatActivity
        supportActivity?.supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        val supportActivity = activity as? AppCompatActivity
        supportActivity?.supportActionBar?.hide()
    }
    private fun initData() {

        listOfItem.add(IntroInfo("Car Insurance", "60% discount on your first ride",R.drawable.car))

        listOfItem.add(IntroInfo("Bike Insurance", "40% discount on your first ride",R.drawable.bike))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pageViewAdapter = ScreenSliderPageAdapter(this, listOfItem)
        val viewPager = view.findViewById<ViewPager2>(R.id.vbIntro)
        viewPager.adapter = pageViewAdapter

        TabLayoutMediator( view.findViewById(R.id.intoTabLayout), viewPager) { tab, position ->}.attach()

        val btnSign = view.findViewById<TextView>(R.id.btnSignIn)
        btnSign.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
        val register = view.findViewById<TextView>(R.id.btnRegister)
        register.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
        }
    }
}