package com.example.githubapifetch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    RecyclerView recyclerView;
    Adapter Adapter;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String pattern = "yyyy-MM-dd";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        String date = simpleDateFormat.format(cal.getTime());

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
                Adapter = new Adapter(items);

                recyclerView = (RecyclerView)findViewById(R.id.TvShows);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(Adapter);

            }




            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.d("fail", t.getMessage());
            }




        });



    }
}
