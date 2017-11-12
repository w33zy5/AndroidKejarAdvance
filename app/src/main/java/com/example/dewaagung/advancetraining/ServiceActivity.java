package com.example.dewaagung.advancetraining;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dewaagung.advancetraining.receiver.MyBroadcastReceiver;
import com.example.dewaagung.advancetraining.service.MyService;

/**
 * Created by Dewa Agung on 12/11/17.
 */

public class ServiceActivity extends AppCompatActivity {

    private MyBroadcastReceiver receiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        this.registerReceiver(receiver, filter);
        this.registerReceiver(receiver, filter);

        Button btnStartService = findViewById(R.id.btn_start_service);
        btnStartService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startService(new Intent(ServiceActivity.this, MyService.class));
            }
        });
    }
}
