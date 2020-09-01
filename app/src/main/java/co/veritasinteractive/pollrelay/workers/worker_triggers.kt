package co.veritasinteractive.pollrelay.workers

import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

fun startWorkers(context: Context) {
    startUgDataDownLoadWorker(context)
}

fun startUgDataDownLoadWorker(context: Context) {
    val downloadWorkRequest: WorkRequest = PeriodicWorkRequest.Builder(
        UgDataDownloadWorker::class.java,
        60,
        TimeUnit.SECONDS)
        .build()

    WorkManager.getInstance(context).enqueue(downloadWorkRequest)
}