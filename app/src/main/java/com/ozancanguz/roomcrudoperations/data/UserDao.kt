package com.ozancanguz.roomcrudoperations.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun insert(user:User)

    @Query("select * from user_table order by id ASC")
    fun readAllData():LiveData<List<User>>
}