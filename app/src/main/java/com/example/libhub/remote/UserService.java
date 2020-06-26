package com.example.libhub.remote;

import com.example.libhub.Model.Book;
import com.example.libhub.Model.Result;
import com.example.libhub.Model.Trans;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UserService {

    @GET("read.php")
    Call<List<Book>> getBooks(@Query("id") int id);

    @GET("return.php")
    Call<List<Trans>> getreturn();
    @GET("search.php")
    Call<List<Book>> searchbook(@Query("name") String name);

    @FormUrlEncoded
    @POST("login.php")
    Call<Result> login(

            @Field("usn") String usn,
            @Field("password") String password
    );
}
