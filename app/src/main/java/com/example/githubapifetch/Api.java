package com.example.githubapifetch;


import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    String BASE_URL="https://api.github.com/";
    @GET("search/repositories")
    Call<Repo> getRepos(@Query("q") String createdDate,
                        @Query("sort") String stars,
                        @Query("order") String desc);

}
