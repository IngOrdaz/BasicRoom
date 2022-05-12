package com.nbd.basicroom.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val  TABLE_USERS="users"
const val DATABASE_VERSION=1
const val DATABASE_NAME="appdatabase.sqlite"

//creacion de bd
@Database(entities = [UserEntity::class],//aqui van las entitis que deseamops usar en el ejemplo solo hay 1
    version = DATABASE_VERSION

    )

abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
}