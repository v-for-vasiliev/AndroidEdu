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
    }

    // Метод инициализирующий View активити. Поиск элементов на лэйауте,
    // задание listener'ов для кнопок и т.д.
    private void initView() {
        // Ищем элементы по их id в layout'e.
        welcomeMsgText = findViewById(R.id.welcome_message_text);
        changeMsgButton = findViewById(R.id.change_message_button);
        // Задаем листенер кликов по кнопке
        changeMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Запускаем активити, в котором будем вводить новое приветственное сообщение
                startChangeMessageActivity();
            }
        });
    }

    private void startChangeMessageActivity() {
        // Intent - обьект для передачи в нем параметров и данных для различных действий в андроиде
        // this - потому что класс Activity - наследник класса Content
        // ChangeWelcomeMessageActivity.class - класс активити, которую хотим запустить
        Intent startIntent = new Intent(this, ChangeWelcomeMessageActivity.class);
        // У Activity есть метод startActivityForResult, который запускает активти,
        // способное вернуть результат обратно в это активити.
        // Поскольку данное активити может запускать >1 активити, возвращающих результат,
        // нужен идентификатор для каждого из них - Request Code.
        startActivityForResult(startIntent, ChangeWelcomeMessageActivity.REQUEST_CODE);
    }

    // Переопишем метод активти onActivityResult. Этот метод вызовет система,
    // если активити запущенное из данного активити вернуло результат
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Проверяем что request code наш и результат OK (бывает RESULT_CANCEL, если юзер не
        // хочет возвращать результат).
        if (requestCode == ChangeWelcomeMessageActivity.REQUEST_CODE
                && resultCode == Activity.RESULT_OK) {
            // data возвращается опционально, она помечена как @Nullable
            if (data != null) {
                String newWelcomeMsg = data.getStringExtra(
                        ChangeWelcomeMessageActivity.RESULT_EXTRA_WELCOME_MESSAGE);
                // Данные вытаскиваются и засовываются в Intent по строковому ключу
                if (!TextUtils.isEmpty(newWelcomeMsg)) {
                    // Задаем новое значение
                    welcomeMsgText.setText(newWelcomeMsg);
                }
            }
        } else { // Если request code на наш или результат не ОК, просто вызываем обработчик по
            // умолчанию
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
