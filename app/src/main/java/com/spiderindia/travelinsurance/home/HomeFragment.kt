package com.spiderindia.travelinsurance.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.common.TIApplication
import com.spiderindia.travelinsurance.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        binding.user = TIApplication.currUser

        binding.btnInsured.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_vehicleListFragment)
        }
        binding.btnBetterRate.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_vehicleListFragment)
        }

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}