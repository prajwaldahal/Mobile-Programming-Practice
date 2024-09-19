package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @Headers({"Accept: application/json","Accept-Language:en-US,en"})
    @GET("{username}")
    Call<List<Book>> getPost(@Path("username") String username);
}
