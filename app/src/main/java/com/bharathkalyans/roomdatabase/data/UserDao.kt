package com.bharathkalyans.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)


    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllData() : LiveData<List<User>>



}