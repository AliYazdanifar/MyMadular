package ir.engineerpc.ThereadsAndServices;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class DownloadHandler extends Handler {

    @Override
    public void handleMessage(@NonNull Message msg) {

        switch (msg.obj.toString()) {
            case "downloadsong":
                downloadSong("alisong");
                break;

            case "getMainPosts":
                Log.i("ALI", "GET ALL POSTs");
        }

        downloadSong(msg.obj.toString());
    }

    private void downloadSong(String song) {
        Log.i("Ali", song);
        long endTime = System.currentTimeMillis() + 5 * 1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i("ALI", "Dowload Completed!");
    }

}
