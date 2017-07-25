package com.millet.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class SecondActivity extends AppCompatActivity {

    public static void launch(Context _context) {
        Intent _intent = new Intent(_context, SecondActivity.class);
        _context.startActivity(_intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

}
