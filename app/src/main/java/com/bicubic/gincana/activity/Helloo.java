package com.bicubic.gincana.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.bicubic.gincana.R;

public class Helloo extends AppCompatActivity {

    private Object data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloo);

        getData();
    }

    public Object getData() {
        return data;
    }
}
