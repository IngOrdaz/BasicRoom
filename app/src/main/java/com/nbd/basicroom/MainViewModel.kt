package com.nbd.basicroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbd.basicroom.database.DatabaseManager
import com.nbd.basicroom.database.MyCoroutines
import com.nbd.basicroom.database.User
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val savedUsers=MutableLiveData<List<User>>()

    fun saveUser(user: User){
        viewModelScope.launch {
            val userDao=DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
        }
    }

    fun deleteUser(user:User){
        viewModelScope.launch {
            val userDao=DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }
    }

    fun getUsers(){
        viewModelScope.launch {
            val userDao=DatabaseManager.instance.database.userDao()
            savedUsers.value=MyCoroutines(userDao).getUsers().value
        }
    }
}
