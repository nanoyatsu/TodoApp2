package com.nanoyatsu.todoapp2.domain.task

import com.nanoyatsu.todoapp2.data.db.entity.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAll(): Flow<List<Task>>
}