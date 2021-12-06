package com.nanoyatsu.todoapp2.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nanoyatsu.todoapp2.core.TodoApplication
import com.nanoyatsu.todoapp2.data.db.dao.TaskDao
import com.nanoyatsu.todoapp2.data.db.entity.Task


@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: TodoDatabase? = null

        @Synchronized
        fun getInstance(): TodoDatabase {
            if (INSTANCE is TodoDatabase) return INSTANCE!!
            INSTANCE = Room.databaseBuilder(
                TodoApplication.appContext,
                TodoDatabase::class.java,
                "TODO_DB"
            ).build()
            return INSTANCE!!
        }
    }
}