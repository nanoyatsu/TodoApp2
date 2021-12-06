package com.nanoyatsu.todoapp2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.nanoyatsu.todoapp2.data.db.entity.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM Task")
    fun getAllFlow(): Flow<List<Task>>

    @Query("UPDATE Task SET completed = :completed WHERE id = :id")
    fun update(id: Int, completed: Boolean)

}