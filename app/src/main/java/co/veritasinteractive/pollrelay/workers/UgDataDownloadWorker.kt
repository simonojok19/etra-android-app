package co.veritasinteractive.pollrelay.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import co.veritasinteractive.pollrelay.data.PollRelayDatabase
import co.veritasinteractive.pollrelay.data.dao.UgDataDao

class UgDataDownloadWorker(
    context: Context,
    workerParams: WorkerParameters): Worker(
    context,
    workerParams
) {
    private var ugDataDao: UgDataDao = PollRelayDatabase.getDatabase(context).ugDataDao()


    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}