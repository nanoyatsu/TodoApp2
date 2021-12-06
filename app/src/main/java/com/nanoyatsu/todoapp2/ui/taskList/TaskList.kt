package com.nanoyatsu.todoapp2.ui.taskList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nanoyatsu.todoapp2.data.db.entity.Task
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onEach

@Composable
fun TaskListRoute() {
    Row {
        TaskList()
    }
}

@Composable
fun TaskList() {
    val vm: TaskListViewModel = viewModel()
    val taskList = listOf<Task>(
        Task(1, "task-no-namae1", true),
        Task(2, "task-no-namae2", false),
        Task(3, "task-no-namae3", true),
        Task(4, "task-no-namae4", false),
        Task(5, "task-no-namae5", true),
        Task(6, "task-no-namae6", false),
        Task(7, "task-no-namae7", true),
        Task(8, "task-no-namae8", false),
        Task(9, "task-no-namae9", true),
        Task(10, "task-no-namae10", false),
    )
    LazyColumn() {
        //vm.allTask.distinctUntilChanged().onEach {
        items(taskList) { task -> TaskItem(task = task) }
        //}
    }
}

@Composable
fun TaskItem(task: Task) {
    Row() {
        Text(text = task.label)
        Checkbox(checked = task.completed, onCheckedChange = {})
    }
}

//@Composable
//fun NewTaskForm() {
//    TextField(value = "", onValueChange = )
//}

@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(task = Task(1, "task-lavel", true))
}