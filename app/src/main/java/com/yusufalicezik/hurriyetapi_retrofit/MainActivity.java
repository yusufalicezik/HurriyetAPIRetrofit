package com.yusufalicezik.hurriyetapi_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RestInterface restInterface;
    public static String apikey="9b12673f4a3946c98aedcc1e3c6c6ca0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String,String> params = new HashMap<String, String>();
        params.put("apikey",apikey);
        params.put("accept","application/json");


        restInterface=ApiClient.getClient().create(RestInterface.class);
        Call<List<HaberlerData>> call=restInterface.getHaberler(params);
        call.enqueue(new Callback<List<HaberlerData>>() {
            @Override
            public void onResponse(Call<List<HaberlerData>> call, Response<List<HaberlerData>> response) {
                Log.e("deneme","basarili");
                Log.e("deneme","url: "+response.toString());
                Log.e("deneme",String.valueOf(response.body().get(0).getTitle()));

            }
            @Override
            public void onFailure(Call<List<HaberlerData>> call, Throwable t) {
                 Log.e("hata", t.getMessage() + "\n" + t.getLocalizedMessage().toString() + "\n");
            }
        });

    }
}
