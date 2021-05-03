package com.demo.servicesinandroid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class StartForegroundService extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);

        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartForegroundService.this, ForegroundService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    ContextCompat.startForegroundService(StartForegroundService.this,
                            intent);
                } else {
                    startService(intent);
                }
            }
        });

        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartForegroundService.this, ForegroundService.class);
                intent.setAction("Stop Service");
                stopService(intent);
            }
        });
    }
}
