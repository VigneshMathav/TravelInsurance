package com.spiderindia.travelinsurance.model.repository

import com.spiderindia.travelinsurance.model.dao.UserDao
import com.spiderindia.travelinsurance.model.mbo.User

class TravelRepository(private val userDao: UserDao) {

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