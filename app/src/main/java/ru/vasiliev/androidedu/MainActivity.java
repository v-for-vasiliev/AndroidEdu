package ru.vasiliev.androidedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.vasiliev.androidedu.samples.activityresult.WelcomeActivity;
import ru.vasiliev.androidedu.samples.apirequest.ApiRequestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView() {
        Button welcomeSampleButton = findViewById(R.id.button_welcome_sample);
        welcomeSampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            }
        });

        Button apiRequestButton = findViewById(R.id.button_api_request_sample);
        apiRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ApiRequestActivity.class));
            }
        });
    }
}
