package ir.engineerpc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import ir.engineerpc.ThereadsAndServices.FrgThreads;
import ir.engineerpc.YazdaniCardPagerModule.FrgCardPager;
import ir.engineerpc.YazdaniGoogleMapModule.FrgGoogleMap;
import ir.engineerpc.YazdaniServicesModule.FrgServices;
import ir.engineerpc.YazdaniToastModule.FrgYazdaniToast;

public class MainActivity extends AppCompatActivity {
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://github.com/ogaclejapan/SmartTabLayout

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Threads And Services", FrgThreads.class)
                .add("CustomToasts and Anim Bg", FrgYazdaniToast.class)
                .add("Card Pager", FrgCardPager.class)
                .add("Google Map Module", FrgGoogleMap.class)
                .add("Services", FrgServices.class)
                .create());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
}
