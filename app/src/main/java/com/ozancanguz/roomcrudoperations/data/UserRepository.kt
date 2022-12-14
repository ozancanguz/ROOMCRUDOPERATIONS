package com.ozancanguz.roomcrudoperations.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData:LiveData<List<User>> =userDao.readAllData()




    suspend fun addUser(user:User){
        userDao.insert(user)
     }





}