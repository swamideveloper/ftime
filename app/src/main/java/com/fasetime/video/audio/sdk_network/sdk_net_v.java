package com.fasetime.video.audio.sdk_network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class sdk_net_v {

    public static final String BASE_URL = "http://ip-api.com/";

    public static sdk_net_d getGeoApiService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(sdk_net_d.class);
    }

}
