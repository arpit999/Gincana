package com.bicubic.gincana.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bicubic.gincana.R;
import com.bicubic.gincana.adapter.TourDetailPagerAdapter;
import com.bicubic.gincana.helper.GlobalUse;
import com.bicubic.gincana.model.TourDetail;
import com.bicubic.gincana.utils.ApiClient;
import com.bicubic.gincana.utils.ApiInterface;
import com.bicubic.gincana.utils.MyApplication;
import com.bicubic.gincana.widget.CustomTextView;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TourDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Integer[] IMAGES = {R.drawable.tut_ic_one, R.drawable.tut_ic_two, R.drawable.tut_ic_three, R.drawable.tut_ic_four, R.drawable.tut_ic_five};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private static final String TAG = TourDetailActivity.class.getSimpleName();
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    Button bt_back;
    TourDetail tourDetail = null;
    CustomTextView tv_tour_description, tv_tour_title, tv_tour_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);

        FindIds();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            getTourDetails(bundle.getString("tourid", ""));
        else
            MyApplication.okMessageDialog(TourDetailActivity.this, "Gincana", "Tourid not found");

    }

    private void FindIds() {

        mPager = (ViewPager) findViewById(R.id.pager);
        bt_back = (Button) findViewById(R.id.bt_back);
        tv_tour_name = (CustomTextView) findViewById(R.id.tv_tour_name);
        tv_tour_title = (CustomTextView) findViewById(R.id.tv_tour_title);
        tv_tour_description = (CustomTextView) findViewById(R.id.tv_tour_description);


        bt_back.setOnClickListener(this);
    }

    private void init() {

//        for (int i = 0; i < IMAGES.length; i++)
//            ImagesArray.add(IMAGES[i]);

        List<TourDetail.ResponseBean.TourAllImageDataBean> allImageTour = tourDetail.getResponse().getTourAllImageData();

        mPager.setAdapter(new TourDetailPagerAdapter(TourDetailActivity.this, allImageTour));

        PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(mPager);

        mPager.setOnTouchListener(new View.OnTouchListener() {
            private float pointX;
            private float pointY;
            private int tolerance = 50;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        return false; //This is important, if you return TRUE the action of swipe will not take place.
                    case MotionEvent.ACTION_DOWN:
                        pointX = event.getX();
                        pointY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        boolean sameX = pointX + tolerance > event.getX() && pointX - tolerance < event.getX();
                        boolean sameY = pointY + tolerance > event.getY() && pointY - tolerance < event.getY();
                        if (sameX && sameY) {
                            int current_item = mPager.getCurrentItem();
//                            Toast.makeText(TutorialActivity.this, "click " + current_item, Toast.LENGTH_SHORT).show();

                            switch (current_item) {
                                case 3:
//                                    finish();
                                    Toast.makeText(TourDetailActivity.this, "Get permission here", Toast.LENGTH_SHORT).show();
                                    mPager.setCurrentItem(current_item + 1, false);
                                    break;
                                case 4:
//                                    finish();
                                    startActivity(new Intent(TourDetailActivity.this, HomeScreenActivity.class));
                                    finish();
                                    break;
                                default:
                                    mPager.setCurrentItem(current_item + 1, false);

                                    break;
                            }

//                            mPager.setCurrentItem(current_item + 1, false);
//                            Toast.makeText(TutorialActivity.this, "Toatal Page "+mPager.getAdapter().getCount(), Toast.LENGTH_SHORT).show();
                            //The user "clicked" certain point in the screen or just returned to the same position an raised the finger
                        }
                }
                return false;
            }
        });

        NUM_PAGES = IMAGES.length;


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        /*mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

    }

    public void getTourDetails(String tourid) {

//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        IMEI = telephonyManager.getDeviceId();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog progressDialog = new ProgressDialog(TourDetailActivity.this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.show();

        SharedPreferences sharedPreferences = getSharedPreferences("preference", 0);
        String userid = sharedPreferences.getString("userid", "");
        Log.i(TAG, "getTourDetails: userid : " + userid);
        Map<String, RequestBody> map = null;

        map = new HashMap<>();
        map.put("action", GlobalUse.toRequestBody("GetTourDetail"));
        map.put("tourId", GlobalUse.toRequestBody(tourid));
        map.put("userId", GlobalUse.toRequestBody(userid));

        Call<TourDetail> responseCall = apiInterface.getTourDetail(map);

        responseCall.enqueue(new Callback<TourDetail>() {
            @Override
            public void onResponse(Call<TourDetail> call, Response<TourDetail> response) {

                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                tourDetail = response.body();
                Log.i(TAG, "onResponse: errorcode :" + tourDetail.getResponse().getErrorCode());


                if (tourDetail.getResponse().isResult()) {

                    tv_tour_name.setText(tourDetail.getResponse().getTourData().getSTourName());
                    tv_tour_title.setText(tourDetail.getResponse().getTourData().getSTourName());
                    tv_tour_description.setText(tourDetail.getResponse().getTourData().getSLongDescription());

                    init();

                    Log.i(TAG, "onResponse: ErrorDesc : " + tourDetail.getResponse().getErrorDescription());
                    Log.i(TAG, "onResponse: tourName :" + tourDetail.getResponse().getTourData().getSTourName());

                } else {
                    Toast.makeText(TourDetailActivity.this, "" + tourDetail.getResponse().getErrorCode(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<TourDetail> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                MyApplication.okMessageDialog(TourDetailActivity.this, "Gincana", t.getMessage());

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_back:

                finish();

                break;

            default:

                break;

        }
    }
}
