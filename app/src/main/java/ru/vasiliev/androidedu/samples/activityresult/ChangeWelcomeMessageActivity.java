package ru.vasiliev.androidedu.samples.activityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.vasiliev.androidedu.R;

public class ChangeWelcomeMessageActivity extends AppCompatActivity {

    public static final String RESULT_EXTRA_WELCOME_MESSAGE = "result_extra_welcome_message";

    public static final int REQUEST_CODE = 101;

    private EditText welcomeMsgEdit;

    private Button saveMsgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_welcome_message);
        // Начальный результат - CANCELLED - если юзер не введет новое приветственное сообщение
        // и закрое это активти.
        setResult(Activity.RESULT_CANCELED);
        initView();
    }

    // Инициализируем View
    private void initView() {
        welcomeMsgEdit = findViewById(R.id.welcome_message_edit);
        saveMsgButton = findViewById(R.id.save_welcome_message_button);
        saveMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(welcomeMsgEdit.getText().toString())) {
                    Toast.makeText(ChangeWelcomeMessageActivity.this, "Введите сообщение!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // Если введенные данные валидны (!=null и текст не пустой)
                    // Создаем Intent для возврата результата и кладем в него новую строку
                    // приветствия
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(RESULT_EXTRA_WELCOME_MESSAGE,
                            welcomeMsgEdit.getText().toString());
                    // Задаем result code = OK
                    setResult(Activity.RESULT_OK, resultIntent);
                    // Закрываем активити
                    finish();
                }
            }
        });
    }
}
