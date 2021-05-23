package com.example.recorder.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recording_table")
data class RecordingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val filePath: String,
    val length: Long,
    val time: Long
)