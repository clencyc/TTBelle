package com.example.mylistview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mylistview.data.User
import com.example.mylistview.repository.Repository
import com.example.mylistview.data.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//role of this viewmodel is to provide data to the UI and
//service configuration changes. A viewmodel acts as a communication center
//between the repo and the UI
class ViewModel(application: Application): AndroidViewModel(application){

    val readAllData: LiveData<List<User>>
    private val repository: Repository


    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = Repository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
        }
    }
