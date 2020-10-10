package com.example.kotlinkeywords.data

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope

class FillData(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = coroutineScope {
        try {
            val database = KeywordDatabase.getInstance(applicationContext)
            database.keywordDao().insert(dummyKeywords)
            Result.success()
        } catch (exception: Exception) {
            Log.e(TAG, "Error filling data", exception)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "FillData"
    }
}