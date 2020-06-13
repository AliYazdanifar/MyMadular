package ir.engineerpc.YazdaniToastModule;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import ir.engineerpc.R;
import ir.engineerpc.YazdaniButtonsModule.YazdaniButtons;
import ir.engineerpc.YazdaniDialogModule.YazdaniDialog;

public class FrgYazdaniToast extends Fragment {

    View view;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btnDialog;

    private LinearLayout linearLayout;
    private AnimationDrawable animationDrawable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_yazdani_toast, container, false);

        init();

        YazdaniButtons.showSecondaryToast(linearLayout, getActivity(), "Testtt");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                getActivity().startService(new Intent(getActivity(), TestService.class));
                Intent serviceIntent = new Intent(getActivity(), TestService.class);
                serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");
                ContextCompat.startForegroundService(getActivity(), serviceIntent);

                YazdaniToast.showSecondaryToast(getActivity(), "Secondary Toast");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                YazdaniToast.showSuccessToast(getActivity(), "Success Toast");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniToast.showWarningToast(getActivity(), "Warning Toast");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniToast.showDangerToast(getActivity(), "Danger Toast");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniToast.showPrimaryToast(getActivity(), "Primary Toast");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniToast.showInfoToast(getActivity(), "Info Toast");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniToast.showLightToast(getActivity(), "Warning Toast");
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YazdaniDialog dialog = new YazdaniDialog(getActivity());
                YazdaniDialog.showDangerDialog(getActivity(), "", "", R.drawable.ic_launcher_background);
                dialog.show();

            }
        });

        return view;

    }

    private void init() {
        linearLayout = view.findViewById(R.id.constraint);
        animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(2000);

        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        btn5 = view.findViewById(R.id.btn5);
        btn6 = view.findViewById(R.id.btn6);
        btn7 = view.findViewById(R.id.btn7);
        btnDialog = view.findViewById(R.id.btn_dialog);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }
}
