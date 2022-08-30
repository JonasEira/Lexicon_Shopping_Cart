package com.lexicon.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyCredentials {
    String url;
    String name;
    String password;
    static String defaultPath = "src/main/resources/credentials";
    public MyCredentials() {
        this(defaultPath);
    }
    public MyCredentials(String path) {
        Properties p = new Properties();
        try (InputStream input = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("url");
            name = prop.getProperty("name");
            password = prop.getProperty("password");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "MyCredentials{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}