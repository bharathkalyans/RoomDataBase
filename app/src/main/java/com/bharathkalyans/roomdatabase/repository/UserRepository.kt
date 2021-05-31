package com.bharathkalyans.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.bharathkalyans.roomdatabase.data.UserDao
import com.bharathkalyans.roomdatabase.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.getAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}