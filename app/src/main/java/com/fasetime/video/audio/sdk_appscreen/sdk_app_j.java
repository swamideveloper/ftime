package com.fasetime.video.audio.sdk_appscreen;

public class sdk_app_j {
    public String name;
    public String code;
    public int resourceId;

    public sdk_app_j(String name, String code, int resourceId) {
        this.name = name;
        this.code = code;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getResourceId() {
        return resourceId;
    }
}
