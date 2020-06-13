package ir.engineerpc.YazdaniToastModule;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

//just add this library     implementation 'androidx.cardview:cardview:1.0.0'

public class YazdaniToast {

    public static void showSecondaryToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#868e96"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }

    public static void showSuccessToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#218838"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }

    public static void showWarningToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#E0A800"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.BLACK);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }

    public static void showDangerToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#C82333"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }

    public static void showPrimaryToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#007BFF"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }

    public static void showInfoToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#17A2B8"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }

    public static void showLightToast(Context context, String message) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(context);
        CardView cardView = new CardView(context);
        cardView.setCardBackgroundColor(Color.parseColor("#aaffffff"));
        cardView.setRadius(12);

        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.BLACK);

        cardView.addView(textView);

//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup) context.findViewById(R.id.toast_root));
        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(cardView);
        toast.show();
    }
}
