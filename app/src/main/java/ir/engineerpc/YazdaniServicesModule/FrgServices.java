package ir.engineerpc.YazdaniServicesModule;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import ir.engineerpc.R;
import ir.engineerpc.YazdaniToastModule.YazdaniToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrgServices extends Fragment {

    private View view;
    private Button btnStart, btnStop, btntwo;
    Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frg_services, container, false);

        intent = new Intent(getActivity(), MyService.class);

        btnStart = view.findViewById(R.id.start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyService myService=new MyService();
                ContextCompat.startForegroundService(getActivity(), intent);            }
        });
        btnStop = view.findViewById(R.id.stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyService.class);
                getActivity().stopService(intent);
            }
        });
        btntwo = view.findViewById(R.id.twoactivity);
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniToast.showSecondaryToast(getActivity().getApplicationContext(), "hello");
            }
        });

        return view;
    }

}
