package com.bicubic.gincana.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bicubic.gincana.R;
import com.bicubic.gincana.adapter.RvNearTours;
import com.bicubic.gincana.helper.CircleTransform;
import com.bicubic.gincana.helper.GlobalUse;
import com.bicubic.gincana.model.NearTour;
import com.bicubic.gincana.utils.ApiClient;
import com.bicubic.gincana.utils.ApiInterface;
import com.bicubic.gincana.utils.MyApplication;
import com.bicubic.gincana.widget.CustomTextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationListener;
import com.mapbox.mapboxsdk.location.LocationServices;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectTourActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SelectTourActivity.class.getSimpleName();
    public MapView mapView;
    private LocationServices locationServices;
    public MapboxMap map;
    private static final int PERMISSIONS_LOCATION = 0;
    RelativeLayout rel_bottom_tour, rel_more_tour;
    ImageView img_tour;
    CustomTextView tv_title, tv_desc;
    Double latitude, longitude;
    Button bt_back;

    BottomSheetBehavior behavior;
    private BottomSheetDialog mBottomSheetDialog;
    List<NearTour.ResponseBean.TourDataBean> nearTourList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(R.layout.activity_select_tour);

        mapView = (MapView) findViewById(R.id.mapView_tour_select);

        findIDs();

        locationServices = LocationServices.getLocationServices(SelectTourActivity.this);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;
                if (map != null) {
                    toggleGps(!map.isMyLocationEnabled());
                }

                /*// Create an Icon object for the marker to use
                IconFactory iconFactory = IconFactory.getInstance(SelectTourActivity.this);
                Drawable shayamal = ContextCompat.getDrawable(SelectTourActivity.this, R.mipmap.marker_red);
                Icon icon_shayamal = iconFactory.fromDrawable(shayamal);

                Drawable sg = ContextCompat.getDrawable(SelectTourActivity.this, R.mipmap.marker_green);
                Icon icon_sg = iconFactory.fromDrawable(sg);

                // Add the custom icon marker to the map
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(23.0133, 72.5308))
                        .title("Shayamal")
                        .icon(icon_shayamal));

                // Add the custom icon marker to the map
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(23.0837, 72.5272))
                        .title("SG Highway")
                        .icon(icon_sg));*/

            }
        });

    }

    private void findIDs() {

        rel_bottom_tour = (RelativeLayout) findViewById(R.id.rel_bottom_tour);
        rel_more_tour = (RelativeLayout) findViewById(R.id.rel_more_tour);
        img_tour = (ImageView) findViewById(R.id.img_tour);
        tv_title = (CustomTextView) findViewById(R.id.tv_title);
        tv_desc = (CustomTextView) findViewById(R.id.tv_desc);
        bt_back = (Button) findViewById(R.id.bt_back);

        /**
         * This is Bottom sheet code
         */
        View bottomSheet = findViewById(R.id.bottom_sheet);
        assert bottomSheet != null;
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });
        behavior.getPeekHeight();

        rel_more_tour.setOnClickListener(this);
        rel_bottom_tour.setOnClickListener(this);
        bt_back.setOnClickListener(this);

    }

    private void showBottomSheetDialog() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        mBottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.sheet, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RvNearTours rvNearTours = new RvNearTours(nearTourList, SelectTourActivity.this);

        recyclerView.setAdapter(rvNearTours);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }

    private void toggleGps(boolean enableGps) {
        if (enableGps) {
            // Check if user has granted location permission
            if (!locationServices.areLocationPermissionsGranted()) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_LOCATION);
            } else {
                enableLocation(true);
            }
        } else {
            enableLocation(false);
        }
    }

    private void enableLocation(boolean enabled) {
        if (enabled) {
            // If we have the last location of the user, we can move the camera to that position.
            Location lastLocation = locationServices.getLastLocation();
            if (lastLocation != null) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastLocation), 11));
                getNearestTours();
            }

            locationServices.addLocationListener(new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null) {
                        // Move the map camera to where the user location is and then remove the
                        // listener so the camera isn't constantly updating when the user location
                        // changes. When the user disables and then enables the location again, this
                        // listener is registered again and will adjust the camera once again.
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location), 11));
                        locationServices.removeLocationListener(this);
                    }
                }
            });
//            floatingActionButton.setImageResource(R.drawable.ic_location_disabled_24dp);
        } else {
//            floatingActionButton.setImageResource(R.drawable.ic_my_location_24dp);
        }
        // Enable or disable the location layer on the map
        map.setMyLocationEnabled(enabled);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableLocation(true);
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rel_bottom_tour:

                Intent intent = new Intent(SelectTourActivity.this, TourDetailActivity.class);
                intent.putExtra("tourid", "1");
                startActivity(intent);

                break;
            case R.id.rel_more_tour:

                showBottomSheetDialog();

                break;
            case R.id.bt_back:

                finish();

                break;
            default:

                break;

        }

    }


    public void getNearestTours() {

//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        IMEI = telephonyManager.getDeviceId();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog progressDialog = new ProgressDialog(SelectTourActivity.this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.show();

        Map<String, RequestBody> map = null;

        if (locationServices != null) {

            latitude = locationServices.getLastLocation().getLatitude();
            longitude = locationServices.getLastLocation().getLongitude();

            Log.i(TAG, "getNearestTours: lat : " + latitude + " long : " + longitude);

            map = new HashMap<>();
            map.put("action", GlobalUse.toRequestBody("getAlltour"));
            map.put("latitude", GlobalUse.toRequestBody(String.valueOf(latitude)));
            map.put("longitude", GlobalUse.toRequestBody(String.valueOf(longitude)));
            map.put("distance", GlobalUse.toRequestBody("10000"));

        } else {
            MyApplication.okMessageDialog(SelectTourActivity.this, "Gincana", "Location not found");
        }

        Call<NearTour> responseCall = apiInterface.getNearestTour(map);

        responseCall.enqueue(new Callback<NearTour>() {
            @Override
            public void onResponse(Call<NearTour> call, Response<NearTour> response) {

                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                NearTour s = response.body();
                Log.i(TAG, "onResponse: errorcode :" + s.getResponse().getErrorCode());

                Log.i(TAG, "onResponse: " + s.getResponse().toString());

                if (s.getResponse().isResult()) {

                    nearTourList = new ArrayList<NearTour.ResponseBean.TourDataBean>();
                    nearTourList = s.getResponse().getTourData();

                    Log.i(TAG, "onResponse: Total : " + s.getResponse().getNumoftour());

                    if (nearTourList.isEmpty()) {
                        MyApplication.okMessageDialog(SelectTourActivity.this, "Gincana", "Near tour not found");
                    } else {
                        Picasso.with(SelectTourActivity.this).load(nearTourList.get(0).getIImageData()).transform(new CircleTransform()).into(img_tour);
                        tv_title.setText(nearTourList.get(0).getSTourName());
                        tv_desc.setText(nearTourList.get(0).getSShortDescription());

                        showBottomSheetDialog();

                        for (int i = 0; i < nearTourList.size(); i++) {

                            addGreenMarker(nearTourList.get(i).getSTourName(), R.mipmap.marker_green, new LatLng(Double.parseDouble(nearTourList.get(i).getSLatitude()), Double.parseDouble(nearTourList.get(i).getSLongitude())));

                        }

                    }

                } else {
                    Toast.makeText(SelectTourActivity.this, "" + s.getResponse().getErrorCode(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<NearTour> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                MyApplication.okMessageDialog(SelectTourActivity.this, "Gincana", t.getMessage());

            }
        });

    }

    public void addGreenMarker(String title, int resource_id, LatLng latLng) {

        // Create an Icon object for the marker to use
        IconFactory iconFactory = IconFactory.getInstance(SelectTourActivity.this);
        Drawable drawable = ContextCompat.getDrawable(SelectTourActivity.this, resource_id);
        Icon icon = iconFactory.fromDrawable(drawable);

        // Add the custom icon marker to the map
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title)
                .icon(icon));

    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}
