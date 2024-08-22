package com.spiderindia.travelinsurance.model.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spiderindia.travelinsurance.model.mbo.User
import com.spiderindia.travelinsurance.model.mbo.Vehicle

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE (username = :username OR email = :username) AND password = :password")
    suspend fun findByUsernamePassword(username: String, password: String): User?

    @Query("SELECT * FROM User WHERE username = :username OR email = :username")
    suspend fun findByUsername(username: String):List<User>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAll()

    @Query("SELECT * FROM VEHICLE WHERE vMake like '%'||:query||'%' OR vYear like '%'||:query||'%' ")
    fun getAllVehicleList(query : String) : PagingSource<Int, Vehicle>

    @Query("SELECT * FROM VEHICLE")
    suspend fun getAllVehicles() : List<Vehicle>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicle:Vehicle)

    @Query("DELETE FROM VEHICLE")
    suspend fun deleteVehicleAll()
}