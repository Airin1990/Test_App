package com.weijie.test_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.weijie.test_app.firebase.FaceBookLogging;
import com.weijie.test_app.firebase.GoogleLogging;
import com.weijie.test_app.firebase.SendDataActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        startActivity(new Intent(this, SendDataActivity.class));
    }

    public void googleLog(View view) {
        startActivity(new Intent(this, GoogleLogging.class));
    }

    public void facebookLog(View view) {
        startActivity(new Intent(this, FaceBookLogging.class));
    }
}
