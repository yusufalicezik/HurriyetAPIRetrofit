package com.yusufalicezik.hurriyetapi_retrofit;

import com.google.gson.annotations.SerializedName;
import com.yusufalicezik.hurriyetapi_retrofit.Model.HaberlerData;

import java.util.List;

public class Data {


    @SerializedName("Title")
    private List<HaberlerData> list;

    public List<HaberlerData> getData() {
        return list;
    }

    public void setMovies(List<HaberlerData> list) {
        this.list = list;
    }
}
