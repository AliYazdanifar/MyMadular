package ir.engineerpc.YazdaniCardPagerModule;


import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import ir.engineerpc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrgCardPager extends Fragment {

    private View view;

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_card_pager, container, false);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.imgf, "Hello Ali Yazdanifar!", "my love is Modular Programming!"));
        models.add(new Model(R.drawable.imgf, "Hello Ali Yazdanifar!", "my love is Modular Programming!"));
        models.add(new Model(R.drawable.imgf, "Hello Ali Yazdanifar!", "my love is Modular Programming!"));
        models.add(new Model(R.drawable.imgf, "Hello Ali Yazdanifar!", "my love is Modular Programming!"));

        adapter = new Adapter(models, getActivity());

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),

        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
//                    viewPager.setBackgroundColor(colors[colors[colors.length - 1]]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

}
