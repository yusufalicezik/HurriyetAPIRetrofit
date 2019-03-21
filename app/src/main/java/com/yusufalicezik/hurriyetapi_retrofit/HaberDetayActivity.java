package com.yusufalicezik.hurriyetapi_retrofit;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yusufalicezik.hurriyetapi_retrofit.Model.HaberDetayData;


import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HaberDetayActivity extends AppCompatActivity {


    public static String gelenId;
    ImageView imageView;
    TextView baslik,haberDetay;

    private RestInterface restInterface;
    public static String apikey="9b12673f4a3946c98aedcc1e3c6c6ca0";
    private HaberDetayData secilenHaber=new HaberDetayData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haber_detay);



        gelenId=getIntent().getStringExtra("id");

        HashMap<String,String> params = new HashMap<String, String>();
        params.put("apikey",apikey);
        params.put("accept","application/json");
        params.put("id",gelenId);




        imageView=findViewById(R.id.detay_imgageview);
        baslik=findViewById(R.id.detay_title);
        haberDetay=findViewById(R.id.detay_Haber);


        restInterface=ApiClient.getClient().create(RestInterface.class);
        Call<HaberDetayData> call=restInterface.getHaberDetay(params);
        call.enqueue(new Callback<HaberDetayData>() {
            @Override
            public void onResponse(Call<HaberDetayData> call, Response<HaberDetayData> response) {


           secilenHaber.setText(response.body().getText());
           secilenHaber.setTitle(response.body().getTitle());
           secilenHaber.setFiles(response.body().getFiles());


           Log.e("yusufy",secilenHaber.getText().toString());
           haberDetay.setText(secilenHaber.getText());

           Glide.with(getApplicationContext()).load(secilenHaber.getFiles().get(0).getFileUrl().toString())
                        .into(imageView);


           baslik.setText(secilenHaber.getTitle());


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    haberDetay.setText(Html.fromHtml(secilenHaber.getText(), Html.FROM_HTML_MODE_COMPACT));
                } else {
                    haberDetay.setText(Html.fromHtml(secilenHaber.getText()));
                }




            }
            @Override
            public void onFailure(Call<HaberDetayData> call, Throwable t) {
                Log.e("hatay", t.getMessage() + "\n" + t.getLocalizedMessage().toString() + "\n" + t.getStackTrace().toString()+":" +
                        ":"+call.toString());
            }
        });




    }
}
