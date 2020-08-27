package com.bicubic.gincana.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.bicubic.gincana.R;
import com.bicubic.gincana.adapter.RvUserAccount;
import com.bicubic.gincana.helper.RecyclerItemClickListener;
import com.bicubic.gincana.utils.MyApplication;

import java.util.ArrayList;

public class UserAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Integer[] IMAGES = {R.drawable.tut_ic_one, R.drawable.tut_ic_two, R.drawable.tut_ic_three, R.drawable.tut_ic_four, R.drawable.tut_ic_five, R.drawable.tut_ic_three, R.drawable.tut_ic_four, R.drawable.tut_ic_five, R.drawable.tut_ic_three, R.drawable.tut_ic_four, R.drawable.tut_ic_five};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    RecyclerView rv_complete_tours, rv_vouchers, rv_badges;
    Button bt_back;
    Button bt_profile_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        FindIds();

        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        RvUserAccount rvUserAccount = new RvUserAccount(0, ImagesArray, UserAccountActivity.this);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(UserAccountActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rv_complete_tours.setLayoutManager(linearLayoutManager);
        rv_complete_tours.setHasFixedSize(true);
        rv_complete_tours.setItemAnimator(new DefaultItemAnimator());
        rv_complete_tours.setAdapter(rvUserAccount);

        RecyclerView.LayoutManager linearLayoutManager1 = new LinearLayoutManager(UserAccountActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rv_vouchers.setLayoutManager(linearLayoutManager1);
        rv_vouchers.setHasFixedSize(true);
        rv_vouchers.setItemAnimator(new DefaultItemAnimator());
        rv_vouchers.setAdapter(rvUserAccount);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(UserAccountActivity.this, 4);
        rv_badges.setLayoutManager(gridLayoutManager);
        rv_badges.setHasFixedSize(true);
        rv_badges.setItemAnimator(new DefaultItemAnimator());
        rv_badges.setAdapter(rvUserAccount);

        recycleClick();

    }

    private void recycleClick() {

        rv_complete_tours.addOnItemTouchListener(
                (RecyclerView.OnItemTouchListener) new RecyclerItemClickListener(UserAccountActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        MyApplication.okMessageDialog(UserAccountActivity.this,"Gincana"," Position : "+position);
                    }
                })
        );

        rv_vouchers.addOnItemTouchListener(
                (RecyclerView.OnItemTouchListener) new RecyclerItemClickListener(UserAccountActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        MyApplication.okMessageDialog(UserAccountActivity.this,"Gincana"," Position : "+position);
                    }
                })
        );

        rv_badges.addOnItemTouchListener(
                new RecyclerItemClickListener(UserAccountActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        MyApplication.okMessageDialog(UserAccountActivity.this,"Gincana"," Position : "+position);
                    }
                })
        );

    }

    private void FindIds() {

        rv_complete_tours = (RecyclerView) findViewById(R.id.rv_complete_tours);
        rv_vouchers = (RecyclerView) findViewById(R.id.rv_vouchers);
        rv_badges = (RecyclerView) findViewById(R.id.rv_badges);
        bt_profile_setting = (Button) findViewById(R.id.bt_profile_setting);
        bt_back = (Button) findViewById(R.id.bt_back);

        bt_profile_setting.setOnClickListener(this);
        bt_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_back:

                finish();

                break;
            case R.id.bt_profile_setting:

                startActivity(new Intent(this,SettingProfileActivity.class));

                break;

        }

    }
}
