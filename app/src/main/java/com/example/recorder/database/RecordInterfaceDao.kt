package com.example.recorder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecordInterfaceDao {

    @Insert
    fun insert(item: RecordingItem)

    @Update
    fun update(item: RecordingItem)

    @Query("SELECT * FROM recording_table WHERE id = :key")
    fun getRecord(key: Long?): RecordingItem

    @Query("DELETE FROM recording_table")
    fun clearAll()

    @Query("DELETE FROM recording_table WHERE id = :key")
    fun removeRecord(key: Long?)

    @Query("SELECT * FROM recording_table ORDER BY id DESC")
    fun getAllRecords(): LiveData<MutableList<RecordingItem>>

    @Query("SELECT COUNT(*) FROM recording_table")
    fun getCount(): Int
}