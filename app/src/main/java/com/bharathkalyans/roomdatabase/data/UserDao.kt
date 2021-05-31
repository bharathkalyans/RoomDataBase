package com.bharathkalyans.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bharathkalyans.roomdatabase.model.User

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<User>>


}