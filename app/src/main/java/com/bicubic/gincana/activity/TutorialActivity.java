package com.bicubic.gincana.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bicubic.gincana.R;
import com.bicubic.gincana.adapter.TutorialPagerAdapter;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TutorialActivity extends AppCompatActivity {

    private static final String TAG = TutorialActivity.class.getSimpleName();
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.tut_ic_one, R.drawable.tut_ic_two, R.drawable.tut_ic_three, R.drawable.tut_ic_four, R.drawable.tut_ic_five};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private List<String> IntroTitle = new ArrayList<String>();
    private List<String> IntroDesc = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
//        init();


    }


    private void init() {


        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        String IntroTitleArray[] = getResources().getStringArray(R.array.IntroTitle);
        IntroTitle = Arrays.asList(IntroTitleArray);
        String IntroDescArray[] = getResources().getStringArray(R.array.IntroDesc);
        IntroDesc = Arrays.asList(IntroDescArray);

       /* ArrayList<String> IntroTitle = new ArrayList<String>();
        Resources res = getResources();
        Collections.addAll(IntroTitle, res.getStringArray(R.array.IntroTitle));

        ArrayList<String> IntroDesc = new ArrayList<String>();
        Collections.addAll(IntroTitle, res.getStringArray(R.array.IntroDesc));*/

        Log.i(TAG, "init: title : " + IntroTitle.size() + "  Desc : " + IntroDesc);
        mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setAdapter(new TutorialPagerAdapter(ImagesArray, IntroTitle, IntroDesc, TutorialActivity.this));

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
                                    Toast.makeText(TutorialActivity.this, "Get permission here", Toast.LENGTH_SHORT).show();
                                    mPager.setCurrentItem(current_item + 1, false);
                                    break;
                                case 4:
//                                    finish();
                                    startActivity(new Intent(TutorialActivity.this,HomeScreenActivity.class));
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


       /* CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);*/


        NUM_PAGES = IMAGES.length;


        /*// Auto start of viewpager
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
        }, 3000, 3000);*/

        /*// Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });*/

    }


}
