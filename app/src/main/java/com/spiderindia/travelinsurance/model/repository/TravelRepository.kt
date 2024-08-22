package com.spiderindia.travelinsurance.model.repository

import androidx.paging.PagingSource
import com.spiderindia.travelinsurance.model.dao.UserDao
import com.spiderindia.travelinsurance.model.mbo.User
import com.spiderindia.travelinsurance.model.mbo.Vehicle

class TravelRepository(private val userDao: UserDao) {

    fun fetchVehicleList(query: String): PagingSource<Int, Vehicle> {
        return userDao.getAllVehicleList(query)
    }
    suspend fun fetchVehicles() : List<Vehicle>
    {
        return userDao.getAllVehicles()
    }

    suspend fun findUserByUserName(username: String, email: String): List<User>?{
        return userDao.findByUsername(username)
    }

    suspend fun findByUserNamePassword(username: String, password: String): User?
    {
        return userDao.findByUsernamePassword(username,password)
    }

    suspend fun doRegister(user: User)
    {
        userDao.insert(user)
    }
}