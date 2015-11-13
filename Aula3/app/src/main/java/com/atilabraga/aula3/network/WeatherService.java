package com.atilabraga.aula3.network;

import com.atilabraga.aula3.model.City;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by atilabraga on 10/3/15.
 */
public interface WeatherService {

    @GET("weather")
    Call<City> getCityInfoById(@Query("id") String id);

}
