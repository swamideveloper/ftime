package com.fasetime.video.audio.sdk_api;

import com.fasetime.video.audio.sdk_pojo.sdk_pojo_a;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api_b {

    @GET("getApps/mukesh/facetime_guide/V8WSB6C8ST84/v1/getData.json")
    Call<sdk_pojo_a> getSdkData();

}