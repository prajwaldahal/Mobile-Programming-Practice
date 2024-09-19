package com.example.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://conforming-entrance.000webhostapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Book>> call = jsonPlaceHolderApi.getPost("104006205261242708831");

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NonNull Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    StringBuilder content = new StringBuilder();
                    String id, file, name;
                    List<Book> books = response.body();
                    for (Book book : books) {
                        id = book.getIsbnno();
                        name = book.getName();
                        file = book.getAuthor();
                        content.append("\n\nid= ").append(id).append("\nname= ").append(name).append("\nauthor=").append(file);
                    }
                    textView.setText(content.toString());
                } else {
                    textView.setText("error response code: " + response.code());
                    Log.d("fail", "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                textView.setText("Error: " + t.getMessage());
                Log.d("API Call Error", t.getMessage(), t);
            }
        });
    }

}
