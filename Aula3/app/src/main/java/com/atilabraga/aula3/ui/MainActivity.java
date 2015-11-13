package com.atilabraga.aula3.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.atilabraga.aula3.R;
import com.atilabraga.aula3.WeatherCallback;
import com.atilabraga.aula3.model.City;
import com.atilabraga.aula3.network.WeatherApi;
import com.atilabraga.aula3.network.WeatherAsync;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements WeatherCallback {

    @Bind(R.id.main_image)
    ImageView ivImage;

    @Bind(R.id.main_cities)
    Spinner spnCity;

    @Bind(R.id.main_tv_1)
    TextView tvName;

    @Bind(R.id.main_tv_2)
    TextView tvVisibility;

    @Bind(R.id.main_tv_3)
    TextView tvLatitude;

    @Bind(R.id.main_tv_4)
    TextView tvLongitude;

    private WeatherAsync mTask;
    private HashMap<Integer, City> mCityMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCityMap = new HashMap<>();
        mCityMap.put(0, new City(getString(R.string.api_sapucaia), "Sapucaia"));
        mCityMap.put(1, new City(getString(R.string.api_rio_de_janeiro), "Rio de Janeiro"));
        mCityMap.put(2, new City(getString(R.string.api_belo_horizonte), "Belo Horizonte"));
        mCityMap.put(3, new City(getString(R.string.api_juiz_de_fora), "Juiz de Fora"));
        mCityMap.put(4, new City(getString(R.string.api_maceio), "Maceió"));
        mCityMap.put(5, new City(getString(R.string.api_gracas), "Graças"));
        ArrayList<City> cityList = new ArrayList(mCityMap.values());
//        ArrayList<String> cityNameList = new ArrayList<>();
//        for (City city : cityList) {
//            cityNameList.add(city.getName());
//        }
//        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
//                cityNameList);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCity.setAdapter(adapter);
        spnCity.post(new Runnable() {
            @Override
            public void run() {
                spnCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {
                        City city = mCityMap.get(i);

//                        mTask = new WeatherAsync(MainActivity.this, MainActivity.this);
//                        mTask.execute(city.getId());

                        Call<City> callback = WeatherApi.getInstance().getCityInfoById(city.getId());
                        callback.enqueue(new Callback<City>() {
                            @Override
                            public void onResponse(Response<City> response, Retrofit retrofit) {
                                showInfo(i, response.body());
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }
        });
    }

    @Override
    public void onFinish(String json) {
        City city = new Gson().fromJson(json, City.class);
//        showInfo(city);
    }

    private void showInfo(int i, City city) {
        Glide.with(this).load("http://lorempixel.com/400/200/city/" + i).into(ivImage);
        tvName.setText(city.getName());
        tvVisibility.setText(String.valueOf(city.getVisibility()));
        tvLatitude.setText(city.getCoordinate().getLatitude());
        tvLongitude.setText(city.getCoordinate().getLongitude());
    }
}
