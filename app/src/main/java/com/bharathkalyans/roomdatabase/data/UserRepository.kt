package com.bharathkalyans.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.getAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}