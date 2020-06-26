package com.example.libhub.remote;

public class APIUtils {

    private APIUtils() {
    };


    public static final String API_URL = "http://192.168.1.108/api_2/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }
}