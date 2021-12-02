package com.vertexinc.returns.test.cloudui.resources;

public enum Environment {
    DEV("https://devportal.vertexsmb.com"),
    QA("https://qaportal.vertexsmb.com"),
    STAGE("https://stage.vertexsmb.com"),
    PROD("https://portal.vertexsmb.com");

    private final String envURL;

    Environment(String envURL) {
        this.envURL = envURL;
    }

    public String getURL() {
        return this.envURL;
    }
}
