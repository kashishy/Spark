package com.example.spark;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SparkAPICLient {

    @GET("/test")
    Call<APIServer> serverStatus();
}
