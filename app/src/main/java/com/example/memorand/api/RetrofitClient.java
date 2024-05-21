package com.example.memorand.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://gengram.gerdoc.com/memorand/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    //UserApiService apiService = RetrofitClient.getRetrofitInstance()
    // Obtener la instancia de Retrofit
    //Retrofit retrofit = RetrofitClient.getRetrofitInstance();

    // Crear una instancia de la interfaz de servicios API
    //UserApiService apiService = retrofit.create(UserApiService.class);

// Ahora puedes usar apiService para llamar a cualquier método API definido en UserApiService
}
