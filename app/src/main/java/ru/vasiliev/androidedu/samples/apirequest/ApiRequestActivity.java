package ru.vasiliev.androidedu.samples.apirequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.vasiliev.androidedu.R;

public class ApiRequestActivity extends AppCompatActivity {

    private Button makeApiRequestButton;

    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_request);
        initView();
    }

    void initView() {
        makeApiRequestButton = findViewById(R.id.button_make_request);
        responseText = findViewById(R.id.api_response_text);
        makeApiRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeApiRequest();
            }
        });
    }

    // OkHttp - библиотека для HTTP запросов
    // https://square.github.io/okhttp/
    private void makeApiRequest() {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(
                "https://samples.openweathermap.org/data/2.5/weather").newBuilder();
        urlBuilder.addQueryParameter("q", "London");
        urlBuilder.addQueryParameter("appid", "b6907d289e10d714a6e88b30761fae22");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseText.setText(e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    responseText.setText("Unexpected code " + response);
                } else {
                    responseText.setText(new String(response.body().bytes()));
                }
            }
        });
    }
}
