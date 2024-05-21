package com.example.memorand.api;


import java.util.List;


import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Query;


public interface UserApiService {


    @FormUrlEncoded
    @POST("/login")
    Call<User> login(@Field("username") String username, @Field("password") String password);

    // Cerrar sesión
    @GET("/signout")
    Call<Void> signout();

    // Obtener todos los usuarios
    @GET("/users")
    Call<List<User>> getAllUsers();

    // Obtener un usuario por ID

    @POST("api/userinfo")
    Call<User> getUserInfoById(@Query("user_id") String userId);


    @POST("api/ApiTaskInfo")
    Call<Task> getTaskById(@Query("task_id") String taskId);




    //Lienzos

    //Ideas

    //Notas

    //Tareas

    //Equipos





    // Crear un nuevo usuario
    @FormUrlEncoded
    @POST("users/create")
    Call<User> createUser(@Field("user_email") String email,
                          @Field("user_pass") String password,
                          @Field("user_type") String type,
                          @Field("user_name") String name,
                          @Field("user_pat") String pat,
                          @Field("user_mat") String mat,
                          @Field("user_status") String status,
                          @Field("user_profile") String profile);

    // Actualizar un usuario
    @PUT("/users/update/{id}")
    Call<User> updateUser(@Path("id") String userId, @Body User user);

    // Eliminar un usuario
    @DELETE("/users/delete/{id}")
    Call<Void> deleteUser(@Path("id") String userId);


}
