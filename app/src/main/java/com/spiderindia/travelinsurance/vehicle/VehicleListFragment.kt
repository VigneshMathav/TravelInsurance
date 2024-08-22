package com.spiderindia.travelinsurance.vehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.common.TIApplication
import com.spiderindia.travelinsurance.databinding.FragmentVehicleListBinding
import com.spiderindia.travelinsurance.model.mbo.Vehicle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class VehicleListFragment : Fragment() {


    private var _binding: FragmentVehicleListBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy {
        VehiclePageAdapter(listener = object :
            com.spiderindia.travelinsurance.common.OnItemClickListener<Vehicle> {
            override fun onClick(item: Vehicle?) {
                viewModel.currentVehicleInfo = item
                findNavController().navigate(R.id.action_vehicleListFragment_to_vehicleDetailsFragment)
            }

        })
    }

    private val viewModel by lazy {
        VehicleViewModel.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //insertDummyData()
        _binding = FragmentVehicleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_vehicle_list, menu)
        val searchView: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                search(query)
                return true
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvVehicleList.adapter = adapter
        binding.rvVehicleList.layoutManager = LinearLayoutManager(context)
        search(null)
//        binding.btnAdd.setOnClickListener {
//            val action = VehicleListFragmentDirections.actionVehicleListFragmentToVehicleDetailFragment(true)
//            findNavController().navigate(action)
//
//        }
    }

    fun search(query: String?) {
        lifecycleScope.launch {
            viewModel.getSearchResultStream(query ?: "").collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}



