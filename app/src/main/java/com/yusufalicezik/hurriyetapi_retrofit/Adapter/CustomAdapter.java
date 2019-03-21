package com.yusufalicezik.hurriyetapi_retrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yusufalicezik.hurriyetapi_retrofit.HaberDetayActivity;
import com.yusufalicezik.hurriyetapi_retrofit.Model.HaberlerData;
import com.yusufalicezik.hurriyetapi_retrofit.R;

import java.util.ArrayList;

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.CustomAdapterViewHolder>  {


    private ArrayList<HaberlerData> tumHaberler;
    Context mContext;


    public CustomAdapter(ArrayList<HaberlerData> tumHaberler, Context context)
    {
        this.tumHaberler = tumHaberler;
        this.mContext=context;
    }



    @NonNull
    @Override
    public CustomAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_genel_list,parent,false);
        return new CustomAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final CustomAdapterViewHolder holder, final int i) {

        holder.title.setText(tumHaberler.get(i).getTitle());
        Glide.with(mContext).load(tumHaberler.get(i).getFiles().get(0).getFileUrl().toString())
                .into(holder.imageView);

        holder.aciklama.setText(tumHaberler.get(i).getDescription());


        //herhangi bir resmim tıklandığında; id sini al ve aktivite 2 ye git. ona göre uygun postu getir.
        holder.allLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= tumHaberler.get(i).getId();
                Intent intent=new Intent(mContext,HaberDetayActivity.class);
                intent.putExtra("id",id);
                mContext.startActivity(intent);


            }
        });




    }



    @Override
    public int getItemCount() {
        return tumHaberler.size();
    }

    public class CustomAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView title,aciklama;
        public ImageView imageView;

        public ConstraintLayout allLayout;



        public CustomAdapterViewHolder(View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.cst_haberTitle);
            allLayout=itemView.findViewById(R.id.allLayout);
            aciklama=itemView.findViewById(R.id.cst_HaberDetay);
            imageView=itemView.findViewById(R.id.imagcst_imageView);

            //allLayout u almamın sebebi listede item tıklandığında resme ya da yazıya değil, listview daki
            //bir cell in herhangi bir yerine tıklanınca ikinci aktiviteye geçmesini istemem.
            //aksi halde hem resim için hem de yazı için ayrı ayrı onclick vermem gerekebilirdi.

        }
    }
}