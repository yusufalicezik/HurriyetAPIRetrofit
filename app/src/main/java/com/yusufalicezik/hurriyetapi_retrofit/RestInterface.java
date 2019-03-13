package com.yusufalicezik.hurriyetapi_retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RestInterface {
    /*
    @Headers({
            "accept: application/json",
            "apikey: 9b12673f4a3946c98aedcc1e3c6c6ca0"
    })
    */
    @GET("v1/articles")
    Call<List<HaberlerData>> getHaberler(@QueryMap Map<String, String> params);
}
