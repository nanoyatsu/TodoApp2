package com.nanoyatsu.todoapp2.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nanoyatsu.todoapp2.ui.taskList.TaskListRoute

const val NAV_DEST_TASK_LIST = "task_list"
const val NAV_ROUTE = NAV_DEST_TASK_LIST

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NAV_ROUTE) {
        composable(NAV_DEST_TASK_LIST) { TaskListRoute() }
    }
}