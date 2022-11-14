package com.ozancanguz.roomcrudoperations.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var firstName:String,
    var lastName:String,
    var age: String,
)


