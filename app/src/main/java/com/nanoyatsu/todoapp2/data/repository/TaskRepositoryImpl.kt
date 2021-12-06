package com.nanoyatsu.todoapp2.data.repository

import com.nanoyatsu.todoapp2.data.db.TodoDatabase
import com.nanoyatsu.todoapp2.data.db.entity.Task
import com.nanoyatsu.todoapp2.domain.task.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl : TaskRepository {
    private val dao = TodoDatabase.getInstance().taskDao() // todo DI
    override fun getAll(): Flow<List<Task>> {
        return dao.getAllFlow()
    }
}