package com.fasetime.video.audio.sdk_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class sdk_pojo_b {

    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("cityName")
    @Expose
    private String cityName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}