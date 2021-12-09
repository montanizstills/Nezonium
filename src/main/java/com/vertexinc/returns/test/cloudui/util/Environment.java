package com.vertexinc.returns.test.cloudui.util;

public enum Environment {

    //UseCase.java - example
    VERTEX_HOME_PAGE("https://www.vertexinc.com/"),

    //Environments
    DEV("https://devportal.vertexsmb.com/"),
    QA("https://qaportal.vertexsmb.com/"),
    STAGE("https://stage.vertexsmb.com/"),
    PROD("https://portal.vertexsmb.com/");

    private final String envURL;

    Environment(String envURL) {
        this.envURL = envURL;
    }

    public String getURL() {
        return this.envURL;
    }
}
