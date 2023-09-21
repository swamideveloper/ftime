package com.fasetime.video.audio.sdk_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class sdk_pojo_a {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("settings")
    @Expose
    private sdk_pojo_e SFLoanSt;
    @SerializedName("response")
    @Expose
    private List<sdk_pojo_d> SFLoanAppVariables = new ArrayList<>();

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<sdk_pojo_d> getAppVariables() {
        return SFLoanAppVariables;
    }

    public void setAppVariables(List<sdk_pojo_d> SFLoanAppVariables) {
        this.SFLoanAppVariables = SFLoanAppVariables;
    }

    public sdk_pojo_e getSettings() {
        return SFLoanSt;
    }

    public void setSettings(sdk_pojo_e SFLoanSt) {
        this.SFLoanSt = SFLoanSt;
    }
}