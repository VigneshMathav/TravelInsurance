package com.spiderindia.travelinsurance.slider

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSliderPageAdapter(fragment: Fragment, private val listOfPageContent: List<IntroInfo>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return listOfPageContent.size
    }

    override fun createFragment(position: Int): Fragment {
        return IntroViewFragment.newInstance(listOfPageContent[position])
    }
}