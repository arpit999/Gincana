package com.bicubic.gincana.activity;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bicubic.gincana.R;
import com.bicubic.gincana.dialog.StartDialog;
import com.bicubic.gincana.helper.GlobalUse;
import com.bicubic.gincana.model.TourDetail;
import com.bicubic.gincana.utils.ApiClient;
import com.bicubic.gincana.utils.ApiInterface;
import com.bicubic.gincana.utils.MyApplication;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class StartTourActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = StartTourActivity.class.getSimpleName();
    private MapView mapView;
    private LocationServices locationServices;
    private MapboxMap map;
    private static final int PERMISSIONS_LOCATION = 0;
    Button bt_main, bt_back;
    TourDetail tourDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(R.layout.activity_start_tour);

        locationServices = LocationServices.getLocationServices(StartTourActivity.this);

        mapView = (MapView) findViewById(R.id.mapView);
        bt_main = (Button) findViewById(R.id.bt_main);
        bt_back = (Button) findViewById(R.id.bt_back);

        bt_main.setOnClickListener(this);
        bt_back.setOnClickListener(this);

        locationServices = LocationServices.getLocationServices(StartTourActivity.this);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;
                if (map != null) {
                    toggleGps(!map.isMyLocationEnabled());
                }

                StartDialog newFragment = StartDialog.newInstance();
                newFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogAnimatiion);
                newFragment.show((StartTourActivity.this).getFragmentManager(), "Image Dialog");


               /* // Create an Icon object for the marker to use
                IconFactory iconFactory = IconFactory.getInstance(StartTourActivity.this);
                Drawable shayamal = ContextCompat.getDrawable(StartTourActivity.this, R.mipmap.marker_red);
                Icon icon_shayamal = iconFactory.fromDrawable(shayamal);

                Drawable sg = ContextCompat.getDrawable(StartTourActivity.this, R.mipmap.marker_green);
                Icon icon_sg= iconFactory.fromDrawable(sg);

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




       /* mapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });*/

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
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastLocation), 13));
//                getTourDetails("5");

                new GetTourData().execute();
            }

            locationServices.addLocationListener(new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null) {
                        // Move the map camera to where the user location is and then remove the
                        // listener so the camera isn't constantly updating when the user location
                        // changes. When the user disables and then enables the location again, this
                        // listener is registered again and will adjust the camera once again.
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location), 14));
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


    public class GetTourData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... str) {

            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("action", "GetTourDetail")
                    .add("userId", "15")
                    .add("tourId", "5")
                    .build();
            Request request = new Request.Builder()
                    .url("http://trialme.in/Ginicana/api/getTourFullData.php")
                    .post(formBody)
                    .build();

            String responseString = null;
            try {

                Response response = client.newCall(request).execute();
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                {

                    responseString = response.body().string();
                    System.out.println(responseString);
                    response.body().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            if (response!=null){

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject responseObj = jsonObject.getJSONObject("response");

                    JSONArray coinArray = responseObj.getJSONArray("TourcoinsData");

                    for (int i = 0; i < coinArray.length(); i++) {

                        JSONObject coinObj = coinArray.getJSONObject(i);
                        addGreenMarker(""+coinObj.optString("iTourPlaceID"),R.mipmap.marker_ic_coin,new LatLng(Double.parseDouble(coinObj.optString("sLatitude")),Double.parseDouble(coinObj.optString("sLongitude"))));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }else {

                MyApplication.okMessageDialog(StartTourActivity.this,"Gincana","Not able to find Response");
            }

        }
    }

    public void getTourDetails(String tourid) {

//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        IMEI = telephonyManager.getDeviceId();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        final ProgressDialog progressDialog = new ProgressDialog(StartTourActivity.this);
//        progressDialog.setMessage("Please Wait....");
//        progressDialog.show();

        SharedPreferences sharedPreferences = getSharedPreferences("preference", 0);
        String userid = sharedPreferences.getString("userid", "");
        Log.i(TAG, "getTourDetails: userid : " + userid);
        Map<String, RequestBody> map = null;

        map = new HashMap<>();
        map.put("action", GlobalUse.toRequestBody("GetTourDetail"));
        map.put("tourId", GlobalUse.toRequestBody(tourid));
        map.put("userId", GlobalUse.toRequestBody(userid));

        Call<ResponseBody> responseCall = apiInterface.getTourData(map);


        /*responseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (progressDialog.isShowing())
                    progressDialog.dismiss();

//                ResponseBody  tourDetail = response.body();
//                Log.i(TAG, "onResponse: errorcode :" + tourDetail.getResponse().getErrorCode());

                try {
                    String Response = response.body().toString();

                    Log.i(TAG, "onResponse: response  : "+Response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                *//*if (tourDetail.getResponse().isResult()) {

                    Log.i(TAG, "onResponse: ErrorDesc : " + tourDetail.getResponse().getErrorDescription());
                    Log.i(TAG, "onResponse: tourName :" + tourDetail.getResponse().getTourData().getSTourName());

                    List<> tourcoinsData =  tourDetail.getResponse().getTourcoinsData();
                    if (!tourcoinsData.isEmpty()){

                        for (int i = 0; i < tourcoinsData.size(); i++) {
                            addGreenMarker(""+i,R.mipmap.marker_ic_coin,new LatLng(Double.parseDouble(tourcoinsData.get(i).getSLatitude()),Double.parseDouble(tourcoinsData.get(i).getSLongitude())));
                        }

                    }
                } else {
                    Toast.makeText(StartTourActivity.this, "" + tourDetail.getResponse().getErrorCode(), Toast.LENGTH_SHORT).show();
                }*//*

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                MyApplication.okMessageDialog(StartTourActivity.this, "Gincana", t.getMessage());

            }
        });*/

    }


    public void addGreenMarker(String title, int resource_id, LatLng latLng) {

        // Create an Icon object for the marker to use
        IconFactory iconFactory = IconFactory.getInstance(StartTourActivity.this);
        Drawable drawable = ContextCompat.getDrawable(StartTourActivity.this, resource_id);
        Icon icon = iconFactory.fromDrawable(drawable);

        // Add the custom icon marker to the map
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title)
                .icon(icon));

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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_main:

                /*StartDialog newFragment = StartDialog.newInstance();
                newFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
                newFragment.show((StartTourActivity.this).getFragmentManager(), "Image Dialog");*/

                StartDialog newFragment = StartDialog.newInstance();
                newFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogAnimatiion);
                newFragment.show((StartTourActivity.this).getFragmentManager(), "Image Dialog");

                break;
            case R.id.bt_back:

                finish();

                break;

        }
    }
}
