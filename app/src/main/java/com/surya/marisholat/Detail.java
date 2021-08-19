package com.surya.marisholat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hide the default action bar
        getSupportActionBar().hide();

        //receive data
        String arab = getIntent().getExtras().getString("arab");
        String latin = getIntent().getExtras().getString("latin");
        String terjemah = getIntent().getExtras().getString("terjemah");

        TextView tv_arab = findViewById(R.id.tvArab);
        TextView tv_latin = findViewById(R.id.tvLatin);
        TextView tv_terjemah = findViewById(R.id.tvTerjemah);

        tv_arab.setText(arab);
        tv_latin.setText(latin);
        tv_terjemah.setText(terjemah);
    }
}
