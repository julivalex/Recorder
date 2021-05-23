package com.example.recorder

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.recorder.database.RecordDatabase
import com.example.recorder.database.RecordInterfaceDao
import com.example.recorder.database.RecordingItem
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception
import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class RecordDatabaseTest {

    private lateinit var recordDatabaseDao: RecordInterfaceDao
    private lateinit var database: RecordDatabase

    @Before
    fun createBd() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, RecordDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        recordDatabaseDao = database.recordInterfaceDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun testDatabase() {
        recordDatabaseDao.insert(
            RecordingItem(id = 1L, name = "record", filePath = "filePath", length = 10L, time = 5L)
        )
        val count = recordDatabaseDao.getCount()
        assertEquals(count, 1)
    }
}