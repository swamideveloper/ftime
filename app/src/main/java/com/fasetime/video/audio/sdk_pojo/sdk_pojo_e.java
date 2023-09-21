package com.fasetime.video.audio.sdk_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class sdk_pojo_e {

    @SerializedName("loc_type")
    @Expose
    private String locType;
    @SerializedName("loc_array")
    @Expose
    private List<sdk_pojo_b> SFLoanArr;

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public List<sdk_pojo_b> getLocArray() {
        return SFLoanArr;
    }

    public void setLocArray(List<sdk_pojo_b> SFLoanArr) {
        this.SFLoanArr = SFLoanArr;
    }

}