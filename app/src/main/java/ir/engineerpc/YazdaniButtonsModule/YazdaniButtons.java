package ir.engineerpc.YazdaniButtonsModule;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class YazdaniButtons {


    public static void showSecondaryToast(LinearLayout parentView, Activity activity, String btnText) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

//        LinearLayout linearLayout = new LinearLayout(activity);
        CardView cardView = new CardView(activity);
        cardView.setCardBackgroundColor(Color.parseColor("#868e96"));
        cardView.setRadius(12);

        TextView textView = new TextView(activity);
        textView.setText(btnText);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);

        cardView.addView(textView);

        parentView.addView(cardView);



    }

    public static void btnSuccess(Activity activity) {
        Button button = new Button(activity);

    }

}
