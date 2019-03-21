package com.yusufalicezik.hurriyetapi_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yusufalicezik.hurriyetapi_retrofit.Adapter.CustomAdapter;
import com.yusufalicezik.hurriyetapi_retrofit.Model.HaberlerData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RestInterface restInterface;
    public static String apikey="9b12673f4a3946c98aedcc1e3c6c6ca0";
    private ArrayList<HaberlerData> tumHaberler=new ArrayList<>();
    private CustomAdapter adapter;
    private RecyclerView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        liste=findViewById(R.id.list);
       adapter=new CustomAdapter(tumHaberler,getApplicationContext());

        HashMap<String,String> params = new HashMap<String, String>();
        params.put("apikey",apikey);
        params.put("accept","application/json");


        restInterface=ApiClient.getClient().create(RestInterface.class);
        Call<List<HaberlerData>> call=restInterface.getHaberler(params);
        call.enqueue(new Callback<List<HaberlerData>>() {
            @Override
            public void onResponse(Call<List<HaberlerData>> call, Response<List<HaberlerData>> response) {

                for(int i=0;i<response.body().size();i++){
                    HaberlerData hb=new HaberlerData();
                    hb.setId(response.body().get(i).getId());
                    hb.setContentType(response.body().get(i).getContentType());
                    hb.setCreatedDate(response.body().get(i).getCreatedDate());
                    hb.setDescription(response.body().get(i).getDescription());
                    hb.setFiles(response.body().get(i).getFiles());
                    hb.setModifiedDate(response.body().get(i).getModifiedDate());
                    hb.setPath(response.body().get(i).getPath());
                    hb.setStartDate(response.body().get(i).getStartDate());
                    hb.setTitle(response.body().get(i).getTitle());
                    hb.setTags(response.body().get(i).getTags());

                    tumHaberler.add(hb);
                    Log.e("Yusuf", tumHaberler.get(i).getTitle()+" :: "+tumHaberler.get(i).getDescription());
                }
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setStackFromEnd(false);
                liste.setHasFixedSize(true);
                liste.setLayoutManager(linearLayoutManager);

                liste.setAdapter(adapter);
                adapter.notifyDataSetChanged();


                //adapter atanacak. tıklanınca o item ın id si ile başka bir aktiviyete o id gönderilerek başka bir veri çekme yapılacak.



            }
            @Override
            public void onFailure(Call<List<HaberlerData>> call, Throwable t) {
                 Log.e("hata", t.getMessage() + "\n" + t.getLocalizedMessage().toString() + "\n");
            }
        });



    }
}
