package com.yusufalicezik.hurriyetapi_retrofit;

import com.yusufalicezik.hurriyetapi_retrofit.Model.HaberDetayData;
import com.yusufalicezik.hurriyetapi_retrofit.Model.HaberlerData;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
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

    @GET("v1/articles") //
    Call<HaberDetayData>getHaberDetay(@QueryMap Map<String, String> params);
}

//https://api.hurriyet.com.tr/v1/articles/41153872?apikey=9b12673f4a3946c98aedcc1e3c6c6ca0