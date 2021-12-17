package com.vertexinc.returns.test.cloudui.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Environment {

    //UseCase.java - example
    VERTEX_HOME_PAGE("https://www.vertexinc.com/"),

    //Environments
    DEV("https://devportal.vertexsmb.com/"),
    QA("https://qaportal.vertexsmb.com/"),
    STAGE("https://stage.vertexsmb.com/"),
    PROD("https://portal.vertexsmb.com/");


    private final String envURL;
    private final String username = "vertuser2@vertex.local";
    private final String password;

    Environment(final String envURL) {
        this.envURL = envURL;
        Properties properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/main/resources/UserCredentials.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new Error(e);
        }

        this.password = properties.getProperty(this.name());
    }

    public String getURL() {
        return this.envURL;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
