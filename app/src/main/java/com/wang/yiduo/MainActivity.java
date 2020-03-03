package com.wang.yiduo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wang.push.PushManager;
import com.wang.yiduo.uitls.SingleClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private TextView tvGetToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "oncreate --> aspectTest");
        tvGetToken = findViewById(R.id.tvGetToken);
        tvGetToken.setOnClickListener(this);

    }

    @SingleClick
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvGetToken:
                getToken();
                break;
        }
    }

    private void getToken() {

    }
}
