package co.veritasinteractive.pollrelay.workers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import co.veritasinteractive.pollrelay.data.PollRelayDatabase;
import co.veritasinteractive.pollrelay.data.dao.UgDataDao;

public class JavaUgDataDownloadWorker extends Worker {
    private UgDataDao ugDataDao;
    public JavaUgDataDownloadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ugDataDao = PollRelayDatabase.Companion.getDatabase(context).ugDataDao();
    }

    @NonNull
    @Override
    public Result doWork() {
        return null;
    }
}
