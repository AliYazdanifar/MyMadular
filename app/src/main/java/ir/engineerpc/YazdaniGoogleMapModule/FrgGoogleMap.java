package ir.engineerpc.YazdaniGoogleMapModule;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;
import java.util.Locale;

import ir.engineerpc.R;
import ir.engineerpc.YazdaniToastModule.YazdaniToast;

public class FrgGoogleMap extends Fragment implements OnMapReadyCallback, LocationListener {

    private View view;
    private GoogleMap map;
    private Button btnSetLocOnMap, btnSearchByName;
    private EditText edtSearchByName;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private double myLatitude;
    private double myLongitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frg_google_map, container, false);

        SupportMapFragment mMapFragment = SupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();
        mMapFragment.getMapAsync(this);

        edtSearchByName = view.findViewById(R.id.edt_search);
        btnSearchByName = view.findViewById(R.id.btn_search_by_name);
        btnSearchByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtSearchByName.getText().toString();
                Geocoder geocoder = new Geocoder(getActivity());
                try {
                    List<Address> addresses = geocoder.getFromLocationName(text, 1);
                    Address address = addresses.get(0);
                    String locality = address.getLocality();
                    YazdaniToast.showWarningToast(getActivity(), locality);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);

        }
//
//        Boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//

        btnSetLocOnMap = view.findViewById(R.id.btn_set_location);

        btnSetLocOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), sendLocationService.class);
                getActivity().startService(intent);
            }
        });

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

//        LatLng latLng = new LatLng(32, 52);
//        map.addMarker(new MarkerOptions().position(latLng).title("my Lat and Lng"));
//        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        } else {
            map.setMyLocationEnabled(true);
//            String l = getMyLocationName();
//            YazdaniToast.showDangerToast(getActivity(), l);

        }
//        drawline(32, 52, 36, 54);

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);


    }


    @Override
    public void onLocationChanged(Location location) {
//        if (myLatitude != location.getLatitude() || myLongitude != location.getLongitude()) {
            myLatitude = location.getLatitude();
            myLongitude = location.getLongitude();

            Intent intent = new Intent(getActivity(), sendLocationService.class);
            intent.putExtra("lat", myLatitude);
            intent.putExtra("long", myLongitude);
            getActivity().startService(intent);

//        }

//        LatLng latLng = new LatLng(latitude, longitude);
//        map.addMarker(new MarkerOptions().position(latLng).title("Hello World!"));
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
//        String l = getMyLocationName();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

        YazdaniToast.showPrimaryToast(getContext(), "GPS enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        YazdaniToast.showSecondaryToast(getContext(), "GPS disabled");
    }

    public String getMyLocationName() {

        try {
            List<Address> addresses;
            Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
            addresses = geocoder.getFromLocation(32, 53, 1);

            Address address = addresses.get(0);

//            country = address.getCountryName();
//            city = address.getAdminArea();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "کشور : " + "" + " شهر : " + "";

    }

    public void drawline(double firstLat, double firstLong, double twoLat, double twoLong) {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(new LatLng(firstLat, firstLong)).add(new LatLng(twoLat, twoLong));
        polylineOptions.color(Color.BLUE);
        polylineOptions.width(3);
        map.addPolyline(polylineOptions);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                YazdaniToast.showWarningToast(getActivity(), "Permissions Granted!");
            }

        } else {
            YazdaniToast.showWarningToast(getActivity(), "Permissions not Granted!");
        }
    }


}
