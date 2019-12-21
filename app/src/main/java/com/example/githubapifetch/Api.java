package com.example.githubapifetch;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface Api {




    String BASE_URL="https://api.github.com/";

    @GET("search/repositories?q=created:>2017-10-22&sort=stars&order=desc")
    Call<List<Repo>> getRepos();

}
