package com.example.githubapifetch;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;

public interface Api {


    String BASE_URL="https://api.github.com/";
    @GET("search/repositories?q=created:>{date}&sort=stars&order=desc")
    Call<List<Repo>> getRepos(@Path("date") String date);

}
