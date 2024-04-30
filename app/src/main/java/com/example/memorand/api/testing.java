package com.example.memorand.api;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.memorand.api.UserApiService;  // Asegúrate de ajustar el paquete según donde esté tu interfaz
import com.example.memorand.api.RetrofitClient;  // Ajusta esto a la ubicación de tu clase de cliente Retrofit
import android.util.Log;  // Para los logs
import com.example.memorand.api.User;

import java.io.IOException;

public class testing {
    public static void fetchUserData(String userId) {
        UserApiService apiService = RetrofitClient.getRetrofitInstance().create(UserApiService.class);
        Call<User> call = apiService.getUserById(userId);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        Log.d("UserFetch", "User Name: " + user.getUser_name());
                    } else {
                        Log.d("UserFetch", "No user data received!");
                    }
                } else {
                    // La solicitud no fue exitosa, lee el contenido del error
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("UserFetch", "Request failed with error: " + errorBody);
                    } catch (IOException e) {
                        Log.e("UserFetch", "Error reading error body", e);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserFetch", "Network error: " + t.getMessage());
            }
        });
    }
}
