package ru.vasiliev.androidedu.samples.apirequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.vasiliev.androidedu.R;

public class ApiRequestActivity extends AppCompatActivity {

    private Button mMakeApiRequestButton;

    private TextView mResponseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_request);
    }

    void initView() {
        mMakeApiRequestButton = findViewById(R.id.button_make_request);
        mResponseText = findViewById(R.id.api_response_text);
        mMakeApiRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void makeApiRequest() {

    }
}
