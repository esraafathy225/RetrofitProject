package com.esraa.hp.retrofitproject;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("wgkJgazE")
    Call<ArrayList<Post>> getPosts();

}
