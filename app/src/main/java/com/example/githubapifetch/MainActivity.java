package com.example.githubapifetch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Objects.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String pattern = "yyyy-MM-dd";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        String createdDate = "created:>"+date;
        String stars ="stars";
        String desc="desc";


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Repo> call = api.getRepos(createdDate,stars,desc);
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {

                Repo repos = response.body();
                ArrayList<items> items = repos.getItems();


                    for (items i : items) {
                        for (owner o : i.getOwner() ) {
                            Log.d("name", i.getName());
                            Log.d("description", i.getDescription());
                            Log.d("stargazers_count", i.getStargazers_count());
                            Log.d("login", o.getLogin());
                            Log.d("avatar_url", o.getAvatar_url());
                        }
                    }
                }



            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.d("fail", t.getMessage());
            }
        });
    }
}
