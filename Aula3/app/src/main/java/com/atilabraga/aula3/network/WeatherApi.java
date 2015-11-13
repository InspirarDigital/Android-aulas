package com.atilabraga.aula3.network;

import com.atilabraga.aula3.model.City;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by atilabraga on 10/3/15.
 */
public class WeatherApi {

    private static WeatherApi mApi;
    private WeatherService mService;

    private WeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(WeatherService.class);
    }

    public static WeatherApi getInstance() {
        if (mApi == null) {
            mApi = new WeatherApi();
        }
        return mApi;
    }

    public Call<City> getCityInfoById(String id) {
        return mService.getCityInfoById(id);
    }

}
