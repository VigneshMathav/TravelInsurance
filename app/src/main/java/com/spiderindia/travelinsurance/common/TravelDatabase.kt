package com.spiderindia.travelinsurance.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.spiderindia.travelinsurance.model.mbo.User
import com.spiderindia.travelinsurance.model.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class TravelDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE : TravelDatabase? = null
        fun getDatabase(context : Context):TravelDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    TravelDatabase::class.java,
                    "travel_database").build()
                INSTANCE = instance
                instance
            }

        }
    }


}