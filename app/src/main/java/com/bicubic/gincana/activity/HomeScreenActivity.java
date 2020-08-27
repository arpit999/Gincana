package com.bicubic.gincana.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.bicubic.gincana.R;
import com.bicubic.gincana.widget.RoundedImageView;

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rel_select_tour, rel_get_zone, rel_start;
    RoundedImageView imag_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rel_select_tour = (RelativeLayout) findViewById(R.id.rel_select_tour);
        rel_get_zone = (RelativeLayout) findViewById(R.id.rel_get_zone);
        rel_start = (RelativeLayout) findViewById(R.id.rel_start);
        imag_profile = (RoundedImageView) findViewById(R.id.imag_profile);

        imag_profile.setOnClickListener(this);
        rel_select_tour.setOnClickListener(this);
        rel_start.setOnClickListener(this);
        rel_get_zone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imag_profile:

                startActivity(new Intent(HomeScreenActivity.this, UserAccountActivity.class));

                break;

            case R.id.rel_select_tour:

                startActivity(new Intent(HomeScreenActivity.this, SelectTourActivity.class));

                break;
            case R.id.rel_get_zone:

                startActivity(new Intent(HomeScreenActivity.this, GetToZoneActivity.class));

                break;
            case R.id.rel_start:

                startActivity(new Intent(HomeScreenActivity.this, StartTourActivity.class));

                break;

        }


    }

}
