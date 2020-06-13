package ir.engineerpc.YazdaniDialogModule;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import org.w3c.dom.Text;

import ir.engineerpc.R;

public class YazdaniDialog extends Dialog {


    public YazdaniDialog(Context context) {
        super(context);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.aaaa);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setText("hello blank dialog for first");
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.BLACK);
        linearLayout.addView(textView);


        LinearLayout linearButtons = new LinearLayout(context);
        linearButtons.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearButtons.setOrientation(LinearLayout.HORIZONTAL);
        linearButtons.setHorizontalGravity(Gravity.RIGHT);

        CardView btnPossitive = new CardView(context);
//        btnPossitive.setUseCompatPadding(true);
//        LinearLayout.LayoutParams layoutParams1=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams1.setMargins(10,10,10,10);
        TextView tvP=new TextView(context);
        tvP.setLayoutParams(layoutParams);
        tvP.setText("Possitive");
        tvP.setGravity(Gravity.CENTER);
        btnPossitive.addView(tvP);
        btnPossitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        Button btnNegative = new Button(context);
        btnNegative.setText("Negative");
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        linearButtons.addView(btnPossitive);
        linearButtons.addView(btnNegative);


        linearLayout.addView(linearButtons);


        setContentView(linearLayout);
    }

    public static void showDangerDialog(Activity activity, String Title, String Message, int res) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

        ImageView imageView = new ImageView(activity);
        imageView.setImageResource(res);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(imageView);
        TextView textView = new TextView(activity);
        textView.setText("hello blank dialog for first kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.BLACK);

        linearLayout.addView(textView);

//        GradientDrawable gradientDrawable=new GradientDrawable();
//        gradientDrawable.setColor(Color.argb(255,166,132,185));


        Dialog dialog = new Dialog(activity);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(linearLayout);
//        dialog.getWindow().setBackgroundDrawable(gradientDrawable);

        dialog.show();
    }


}
