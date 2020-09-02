package co.veritasinteractive.pollrelay.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import co.veritasinteractive.pollrelay.UrlsKt;
import co.veritasinteractive.pollrelay.data.PollRelayDatabase;
import co.veritasinteractive.pollrelay.data.dao.UgDataDao;

public class JavaUgDataDownloadWorker extends Worker {
    private UgDataDao ugDataDao;
    private Context context;
    public JavaUgDataDownloadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ugDataDao = PollRelayDatabase.Companion.getDatabase(context).ugDataDao();
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("Worker", "Running The Worker");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, UrlsKt.UG_DATA_URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Worker", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Worker", error.toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(context);

        queue.add(jsonObjectRequest);
        return Result.success();
    }
}
