package ir.engineerpc.ThereadsAndServices;


import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import ir.engineerpc.R;

public class FrgThreads extends Fragment {

    View view;
    Button btnDownload;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.frg_threads, container, false);

        final DownloadThread thread = new DownloadThread();
        thread.setName("Download Thread");
        thread.start();

        btnDownload = view.findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send Message To Handler For Proccessing
                for (String song : PlayList.songs){
                    Message message=Message.obtain();
                    message.obj = song;
                    thread.mHandler.sendMessage(message);
                }
            }
        });


        return view;

    }


}
