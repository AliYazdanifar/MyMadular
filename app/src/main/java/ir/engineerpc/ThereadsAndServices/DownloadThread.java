package ir.engineerpc.ThereadsAndServices;

import android.os.Looper;
import android.util.Log;

public class DownloadThread extends Thread {
    public DownloadHandler mHandler;

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();

//        for (String song : PlayList.songs) {
//            downloadSong(song);
//        }
    }


}
