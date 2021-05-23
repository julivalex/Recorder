package com.example.recorder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DB_NAME = "recorder_app_database"

@Database(entities = [RecordingItem::class], version = 1, exportSchema = false)
abstract class RecordDatabase : RoomDatabase() {

    abstract fun recordInterfaceDao(): RecordInterfaceDao

    companion object {

        @Volatile
        private var instance: RecordDatabase? = null

        fun getInstance(context: Context): RecordDatabase {
            synchronized(this) {
                var instanceDb = instance
                if (instanceDb == null) {
                    instanceDb = Room.databaseBuilder(context.applicationContext, RecordDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                    instance = instanceDb
                }
                return instanceDb
            }
        }
    }
}