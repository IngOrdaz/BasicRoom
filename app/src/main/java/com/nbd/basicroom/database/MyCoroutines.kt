package com.nbd.basicroom.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private  val userDao: UserDao) {

    //save user
    suspend fun save(user:User)= withContext(Dispatchers.IO){
        userDao.save(user.toEntity())
    }

    //delete users
    suspend fun delete(user: User)= withContext(Dispatchers.IO){
        userDao.delete(user.toEntity())
    }

    //get users from db
    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUsersFromDatabase().map {eachUserEntity ->
            eachUserEntity.toUser()})
    }
}