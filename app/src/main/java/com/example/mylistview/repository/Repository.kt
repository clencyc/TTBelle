package com.example.mylistview.repository

import androidx.lifecycle.LiveData
import com.example.mylistview.data.User
import com.example.mylistview.data.UserDao


//for code separation and clean architecture
class Repository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}