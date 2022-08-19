package com.example.jetpacktest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [User::class])
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: MyDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): MyDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java, "my_database"
            )
                .build().apply {
                    instance = this
                }
        }
    }
}