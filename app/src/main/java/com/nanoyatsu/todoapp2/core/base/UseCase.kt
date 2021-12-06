package com.nanoyatsu.todoapp2.core.base

import kotlinx.coroutines.*

/**
 * UseCase部の基底クラス
 * [run]を定義することで、利用側では`クラス名()`の形でデータ呼び出しが可能
 */
abstract class UseCase<in Params, out Return> where Return : Any {

    abstract suspend fun run(params: Params): Return

    operator fun invoke(scope: CoroutineScope, params: Params, onResult: (Result<Return>) -> Unit) {
        val job = scope.async {
            kotlin.runCatching { run(params) }
        }
        scope.launch {
            withContext(Dispatchers.Main) { onResult(job.await()) }
        }
    }
}