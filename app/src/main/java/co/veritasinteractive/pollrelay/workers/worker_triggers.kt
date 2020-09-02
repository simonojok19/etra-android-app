package co.veritasinteractive.pollrelay.workers

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit


fun startWorkers(context: Context) {
    startUgDataDownLoadWorker(context)
}

fun startUgDataDownLoadWorker(context: Context) {


    val constraints: Constraints =  Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()
    val downloadWorkRequest: WorkRequest = PeriodicWorkRequest.Builder(
        UgDataDownloadWorker::class.java,
        60,
        TimeUnit.SECONDS
    )
        .setConstraints(constraints)
        .build()

    WorkManager.getInstance(context).enqueue(downloadWorkRequest)
}