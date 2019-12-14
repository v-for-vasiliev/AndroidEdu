package ru.vasiliev.androidedu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeMsgText;

    private Button changeMsgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeMsgText = findViewById(R.id.welcome_message_text);
        changeMsgButton = findViewById(R.id.change_message_button);
        changeMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startChangeMessageActivity();
            }
        });
    }

    private void startChangeMessageActivity() {
        Intent startIntent = new Intent(this, ChangeWelcomeMessageActivity.class);
        startActivityForResult(startIntent, ChangeWelcomeMessageActivity.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ChangeWelcomeMessageActivity.REQUEST_CODE
                && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String newWelcomeMsg = data.getStringExtra(
                        ChangeWelcomeMessageActivity.RESULT_EXTRA_WELCOME_MESSAGE);
                if (!TextUtils.isEmpty(newWelcomeMsg)) {
                    welcomeMsgText.setText(newWelcomeMsg);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
