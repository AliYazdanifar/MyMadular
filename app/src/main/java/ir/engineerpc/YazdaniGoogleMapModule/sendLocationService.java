package ir.engineerpc.YazdaniGoogleMapModule;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import ir.engineerpc.YazdaniToastModule.YazdaniToast;

public class sendLocationService extends Service implements OnMapReadyCallback, LocationListener {

    private String CHANNEL_ID = "channelId";
    private NotificationManager notifManager;
    double latitude, longitude;
    private GoogleMap map;
    private LocationManager locationManager;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        latitude = intent.getStringExtra("lat");
//        longitude = intent.getStringExtra("long");
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        }
//        YazdaniToast.showDangerToast(getApplicationContext(), "lat = " + latitude + " long = " + longitude);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String offerChannelName = "Service Channel";
            String offerChannelDescription = "Music Channel";
            int offerChannelImportance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notifChannel = new NotificationChannel(CHANNEL_ID, offerChannelName, offerChannelImportance);
            notifChannel.setDescription(offerChannelDescription);
            notifManager = getSystemService(NotificationManager.class);
            notifManager.createNotificationChannel(notifChannel);

        }

        NotificationCompat.Builder sNotifBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("پویا")
                .setSubText("جلوگیری از گم شدن گوشی")
                .setColor(Color.MAGENTA)
                .setContentText("علی یزدانی فر ");

        Notification servNotification = sNotifBuilder.build();

        startForeground(1, servNotification);

        return START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

    }

    @Override
    public void onLocationChanged(Location location) {
//        if (latitude != location.getLatitude() || longitude != location.getLongitude()) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        Log.i("ALI", "lat = " + latitude + " long = " + longitude);
//        YazdaniToast.showWarningToast(getApplicationContext(), "lat = " + latitude + " long = " + longitude);

//        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
