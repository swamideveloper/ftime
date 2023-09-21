package com.fasetime.video.audio.sdk_network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface sdk_net_d {
    @GET("json")
    Call<sdk_net_a> getLocation();
}