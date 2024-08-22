package com.spiderindia.travelinsurance.vehicle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spiderindia.travelinsurance.common.TIApplication
import com.spiderindia.travelinsurance.model.mbo.Vehicle
import com.spiderindia.travelinsurance.model.repository.TravelRepository
import kotlinx.coroutines.flow.Flow

class VehicleViewModel(val repository: TravelRepository) : ViewModel() {

    var currentVehicleInfo : Vehicle? = null

    fun getSearchResultStream(query : String) : Flow<PagingData<Vehicle>>
    {
        return Pager(
            config = PagingConfig(10,10,true, 10*3),
            pagingSourceFactory = {repository.fetchVehicleList(query)}
        ).flow
    }

    companion object{
        @Volatile
        private var INSTANCE : VehicleViewModel? = null
        fun getInstance() : VehicleViewModel{
            return INSTANCE?: synchronized(this){
                val viewModel = VehicleViewModel(VehicleViewModel.INSTANCE!!.repository)
                INSTANCE = viewModel
                viewModel
            }
        }
    }
}